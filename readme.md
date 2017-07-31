## About
This repository is a simple game library based on javafx.

## Philosophy
Every game has a playground or a stage where the actual events occur. It's where the game is played. A playground consists of game objects. Game objects can be anything which takes part in a game, e.g. spaceship, ball, bullet, etc.

The game runs through sequence of steps. Each step is like a frame in a video or animation. You may have seen something like "60 fps." Well it basically means 60 frames per second. In other words, in 1 second, 60 frames are processed.

In each step, you'll do SOMETHING. Maybe, move a ball, trigger animation, remove an object off the playground, etc. Steps can be a way to be synced with real time.

## Rendering
In each step, rendering is done to update graphics on the screen. Each object in the playground has its `step` method called. That's where each object renders itself. As rendering is not done centrally but instead by each and every object individually.