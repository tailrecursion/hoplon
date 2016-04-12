(ns hoplon.index-test
  (:use
    [clojure.test]
    [clj-webdriver.taxi]
    [test-util.fixtures :as fixtures]))

(use-fixtures :each fixtures/selenium-driver!)

(deftest first-test
  (is (= "hello world" (text (element "h1")))))

(deftest ^:wip all-html
  "All HTML tags can be output by Hoplon"
  ; https://developer.mozilla.org/en-US/docs/Web/HTML/Element
  ; http://www.html-5-tutorial.com/all-html-tags.htm
  (doseq [tag [ "a"
                "a[href=\"http://hoplon.io/\"]"
                "abbr"
                "abbr[title=\"Cascading Style Sheet\"]"
                "address"
                "area"
                "area[shape=\"rect\"][coords=\"0,0,100,100\"][href=\"http://hoplon.io\"][alt=\"click me\"]"
                "article"
                "aside"
                "audio"
                "audio[controls]"
                "b"
                "base"
                "base[href=\"http://hoplon.io/images/\"]"
                "bdi"
                "bdo"
                "bdo[dir=\"rtl\"]"
                "blockquote"
                "blockquote[cite=\"http://hoplon.io\"]"
                "body"
                "br"
                "button"
                "button[type=\"button\"]"
                "canvas"
                "caption"
                "cite"
                "code"
                "col"
                "colgroup"
                "datalist"
                "dd"
                "del"
                "details"
                "dfn"
                "div"
                "dl"
                "dt"
                "em"
                "embed"
                "embed[src=\"foo.swf\"]"
                "fieldset"
                "figcaption"
                "figure"
                "footer"
                "form"
                "h1"
                "h2"
                "h3"
                "h4"
                "h5"
                "h6"
                "head"
                "header"
                "hgroup"
                "hr"
                "html"
                "i"
                "iframe[src=\"http://hoplon.io\"]"
                "img"
                "input"
                "input[type=\"text\"]"
                "ins"
                "kbd"
                "label"
                "label[for=\"some-input\"]"
                "li"
                "link"
                "link[rel=\"stylesheet\"][href=\"main.css\"]"
                "menu"
                "menu[type=\"context\"][id=\"mymenu\"]"
                "menuitem"
                "menuitem[label=\"Refresh\"]"
                "map"
                "map[name=\"logomap\"]"
                "mark"
                "meta"
                "meta[charset=\"UTF-8\"]"
                "meter"
                "meter[value=\"2\"][min=\"0\"][max=\"10\"]"
                "nav"
                "object"
                "object[width=\"400\"][height=\"400\"][data=\"helloworld.swf\"]"
                "ol"
                "optgroup"
                "optgroup[label=\"Swedish Cars\"]"
                "option"
                "option[value=\"volvo\"]"
                "output"
                "p"

                "style"
                "title"
                ; content sectioning
                "section"
                ; text content
                "main"
                "pre"
                "ul"
                ; inline text semantics
                "data"
                "q"
                "rp"
                "rt"
                "rtc"
                "ruby"
                "s"
                "samp"
                "small"
                "span"
                "strong"
                "sub"
                "sup"
                "time"
                "u"
                "var"
                "wbr"
                ; image and multimedia
                "track"
                "video"
                ; embedded content
                "param"
                "source"
                ; scripting
                "noscript"
                "script"
                ; demarcating edits
                ; table content
                "table"
                "tbody"
                "td"
                "tfoot"
                "th"
                "thead"
                "tr"
                ; forms
                "input"
                "keygen"
                "legend"
                "meter"
                "progress"
                "select"
                "textarea"
                ; interactive components
                "dialog"
                "summary"]]
    (is (exists? tag))))
    ; (Thread/sleep 5000)))
