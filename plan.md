- a general `brepl` task that does three things:
  - call compiler "manually" with out pointing to a temp dir
  - serve an html page and compiler output on one port
  - open the page in the browser in the background
  - open a websocket (long-polling?) REPL and open a terminal prompt

The goal is to be able to drop into `brepl` a project and to open a quick testing repl using `boot brepl`, with the current project's maven coordinates preloaded.

The problem with how it works currently is that modules must be loaded already in order for the repl to be able to require them.
