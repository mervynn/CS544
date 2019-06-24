# CS544-Enterprise-Architecture
This repository is only for the purpose of reviewing Mingwei He(986262)'s assignment on CS544-Enterprise-Architecture.
Please remember to edit and submit from original repository, NOT HERE.

<h2> 1. Two ways to clone whole projects</h2>
<h3>&nbsp;&nbsp;way1.</h3>
<h4>&nbsp;&nbsp;&nbsp;&nbsp;Clone parent project</h4>
&nbsp;&nbsp;&nbsp;&nbsp;#:git clone https://github.com/mervynn/CS544-Enterprise-Architecture
<h4>&nbsp;&nbsp;&nbsp;&nbsp;Clone submodules</h4>
&nbsp;&nbsp;&nbsp;&nbsp;#:git submodule update --init --recursive

<h3>&nbsp;&nbsp;way2.(recommend)</h3>
<h4>&nbsp;&nbsp;&nbsp;&nbsp;Clone parent project with submodules</h4>
&nbsp;&nbsp;&nbsp;&nbsp;#:git clone --recursive https://github.com/mervynn/CS544-Enterprise-Architecture

<h2>2. Update and reload latest submodules from each original repository.</h2>
#:cd /path..to/CS544-Enterprise-Architecture
#:git submodule update --recursive remote merge

<h2>3. update parent project.</h2>
#:cd /path..to/CS544-Enterprise-Architecture
#:git pull
