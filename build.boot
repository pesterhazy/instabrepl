(set-env!
 :source-paths #{"src"}
 :resource-paths #{"resources"}
 :dependencies '[[org.clojure/clojurescript "1.9.293"]
                 [adzerk/boot-cljs "1.7.228-2"]
                 [pandeiro/boot-http "0.7.3"]
                 [weasel "0.7.0" :exclusions [org.clojure/clojurescript]]
                 [reagent "0.6.0"]])

(require '[adzerk.boot-cljs :refer [cljs]]
         '[pandeiro.boot-http :refer [serve]]
         '[clojure.java.shell :as shell])
(require
 '[cljs.repl :as repl]
 '[cljs.repl.browser :as browser])
(require 'weasel.repl.websocket)

(deftask brepl
  []
  (with-pass-thru _
    (boot.util/info "Opening page in background...\n")
    (shell/sh "bash" "-c" "(sleep 3 && open -g http://localhost:3000/insta.html) </dev/null >/dev/null 2>/dev/null &")
    (boot.util/info "Opening REPL\n")
    ((resolve 'cljs.repl/repl*)
     ((resolve 'weasel.repl.websocket/repl-env) :ip "0.0.0.0" :port 9001)
     {:output-dir "out"
      :optimizations :none
      :cache-analysis true
      :source-map true})))
