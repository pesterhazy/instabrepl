(ns instabrepl.repl
  (:require [cljs.repl :as repl]
            [cljs.repl.browser :as browser]
            [clojure.java.shell :as shell]
            [clojure.core.server :as server]
            boot.util
            weasel.repl.websocket))

(defn accept []
  (repl/repl*
   (weasel.repl.websocket/repl-env :ip "0.0.0.0" :port 9001)
   {:output-dir "out"
    :optimizations :none
    :cache-analysis true
    :source-map true}))

(defn frame []
  (boot.util/info "Starting socket server\n")
  (server/stop-servers)
  (server/start-server {:port 6622
                        :name "foo"
                        :accept 'instabrepl.repl/accept})
  (boot.util/info "Opening terminal\n")
  (clojure.java.shell/sh "open" "-a" "Terminal.app" "foo"))

(defn run []
  (boot.util/info "Opening REPL\n")
  (frame)
  (shell/sh "bash" "-c" "(sleep 3 && open -g http://localhost:3000/insta.html) </dev/null >/dev/null 2>/dev/null &"))
