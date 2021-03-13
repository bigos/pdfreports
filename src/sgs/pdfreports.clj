(ns sgs.pdfreports
  (:require [clojure.data.xml :as xml]
            [tupelo.core :as tup]))


;;; terminal use
;; (require 'sgs.pdfreports)
;; (ns sgs.pdfreports)
;; (tryme)

(defn greet
  "Callable entry point to the application."
  [data]
  (println (str "Hello, " (or (:name data) "World") "!")))

;;; you can return (type (xml/parse-str str))
;;; menu REPL Inspect on returned type gives interesting information
;;; including methods
;;; (.count (tryme))
;;; interseting fields
;; (.tag (tryme))
;; (.attrs (tryme))

;sgs.pdfreports> (type (.content (tryme)))

(defn tryme
  "Try parsing a string."
  []
  (let [str (slurp "/home/jacek/Desktop/Reports/1345098")]
    (xml/parse-str str))

  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (greet {:name (first args)}))
