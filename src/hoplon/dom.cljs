(ns hoplon.dom
  (:require [applied-science.js-interop :as j]
            [clojure.set :as set]
            [hoplon.core :refer [do! normalize-class on!]]))

(defmethod do! :value
  [elem _ v]
  (if (contains? #{"checkbox" "radio"} (j/get elem :type))
    (j/assoc! elem :checked v) 
    (j/assoc! elem :value v)))

(defmethod do! :class
  [elem _ kvs]
  (doseq [[c add?] (normalize-class kvs)]
    (if add?
      (j/call-in elem [:classList :add] (name c))
      (j/call-in elem [:classList :remove] (name c)))))

(defmethod do! :smart-class
  [elem _ kvs]
  (if (map? kvs)
    (do! elem :class kvs)
    (let [new-class-list (if (string? kvs)
                           (j/call kvs :split #"\s+")
                           (clj->js (mapv name kvs)))
          old-class-list (j/get elem .-hoplon-smart-class #{})
          classes-to-remove (set/difference old-class-list (set new-class-list))]
      (j/assoc! elem .-hoplon-smart-class (into old-class-list new-class-list))
      (j/apply-in elem [:classList :add] new-class-list)
      (when-not (empty? classes-to-remove)
        (j/apply-in elem [:classList :remove] (clj->js (vec classes-to-remove)))))))

(defmethod do! :toggle
  [elem _ v]
  (j/assoc-in! elem [:style :display] (if v "" "none")))

(defmethod do! :text
  [elem _ v]
  (j/assoc! elem :textContent (str v)))

(defmethod do! :scroll-to
  [elem _ v]
  (when v
    (j/call elem :scrollIntoView (j/lit {:behavior "smooth"}))))

(extend-type js/Event
  cljs.core/IDeref
  (-deref [this]
    (j/get-in this [:target :value])))

(defmethod on! :hoplon.core/default
  [elem event callback]
  (j/call elem :addEventListener (name event) callback))
