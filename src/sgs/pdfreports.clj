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
    (xml/parse-str str)))

;; (use-tags 6)
(defn use-tags
  "Get Nth tag of the xml file"
  [n]
  (.get (.content (tryme)) n))

(defn pictures []
  (.get (.content (use-tags 8)) 0))

(defn get-attrs [obj]
  (.attrs obj))

(defn cnt [obj n]
  (.get (.content obj) n))

;;; one out of over 500
(defn first-measurement []
  (.get(.content (.get (.content (use-tags 8)) 7)) 0))

(defn first-measurement-better []
  (-> (tryme) (.content) (.get 8) (.content) (.get 7) (.content) (.get 0)))

(defn first-measurement-best []
  (-> (tryme) (cnt 8) (cnt 7) (cnt 0)))

(defn groups []
  (.get (.content (use-tags 8)) 9))

(defn countries []
  (use-tags 9))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (greet {:name (first args)}))
