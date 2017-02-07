(ns instabrepl.core
  (:require [weasel.repl :as repl]
            [cljs.pprint]
            [reagent.core :as r]))

(r/as-element [:div "asdf"])

(defonce x
  (when (exists? js/Symbol)
    (extend-protocol IPrintWithWriter
      js/Symbol
      (-pr-writer [sym writer _]
        (-write writer (str "\"" (.toString sym) "\""))))))

(when-not (repl/alive?)
  (js/console.log "Connecting...")
  (repl/connect "ws://localhost:9001"))
