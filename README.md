# CS544-Enterprise-Architecture
Assignments (labs and homework)

# 1. Two ways to clone whole projects
  ## way1.
  ## Clone parent project
  git clone https://github.com/mervynn/CS544-Enterprise-Architecture
  # Clone submodules
  git submodule update --init --recursive

  ## way2.
  ## Clone parent project with submodules
  git clone --recursive https://github.com/mervynn/CS544-Enterprise-Architecture

## 2. Update and reload latest submodules from each original repository (Usually no need to do this.)
git submodule update --recursive remote merge


## 3. normal update 
git submodule update --init --recursive

## 4. update parent project.
git pull



