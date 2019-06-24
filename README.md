# CS544-Enterprise-Architecture
Assignments (labs and homework)

<h2> 1. Two ways to clone whole projects</h2>
<h3> way1.</h3>
<h4>&nbsp;&nbsp;&nbsp;&nbsp;Clone parent project</h4>
&nbsp;&nbsp;&nbsp;&nbsp;git clone https://github.com/mervynn/CS544-Enterprise-Architecture
<h4>&nbsp;&nbsp;&nbsp;&nbsp;Clone submodules</h4>
&nbsp;&nbsp;&nbsp;&nbsp;git submodule update --init --recursive

<h3> way2.</h3>
<h4>&nbsp;&nbsp;&nbsp;&nbsp;Clone parent project with submodules</h4>
&nbsp;&nbsp;&nbsp;&nbsp;git clone --recursive https://github.com/mervynn/CS544-Enterprise-Architecture

<h2>2. Update and reload latest submodules from each original repository (Usually no need to do this.)</h2>
git submodule update --recursive remote merge


<h2>3. normal update</h2>
git submodule update --init --recursive

<h2>4. update parent project.</h2>
git pull



