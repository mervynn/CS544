## CS544-Enterprise-Architecture
This repository is only used for reviewing Mingwei He(986262)'s assignments on CS544 at MUM.<br/>
(For edit and submit purpose, please go to original repository)

<h3> 1. Two ways to clone this projects</h3>
<h3>&nbsp;&nbsp;way1.(recommend)</h3>
<h4>&nbsp;&nbsp;&nbsp;&nbsp;Clone parent project with submodules</h4>
&nbsp;&nbsp;&nbsp;&nbsp;#:git clone --recursive https://github.com/mervynn/CS544-Enterprise-Architecture

<h3>&nbsp;&nbsp;way2.</h3>
<h4>&nbsp;&nbsp;&nbsp;&nbsp;a. clone parent project</h4>
&nbsp;&nbsp;&nbsp;&nbsp;#:git clone https://github.com/mervynn/CS544-Enterprise-Architecture
<h4>&nbsp;&nbsp;&nbsp;&nbsp;b. clone submodules</h4>
&nbsp;&nbsp;&nbsp;&nbsp;#:git submodule update --init --recursive

<h3>2. Update and reload latest submodules from each original repository.</h3>
#:cd /path..to/CS544-Enterprise-Architecture<br/>
#:git submodule update --recursive remote merge

<h3>3. update parent project.</h3>
#:cd /path..to/CS544-Enterprise-Architecture<br/>
#:git pull
