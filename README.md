
Saline
=======

Minecraft mod adding salt

TODO
=======

### Features
* Oceans now generate with salt-water instead of regular water
  * Appropriate mixins to fix water-specific ocean generating features
  * Special thanks to https://github.com/no-name-provided/NNP-Fluidlogging for how to add fluid-logging in an efficient way.
  * salt-water fluid-logs all blocks that are water-loggable.
  * Water source with 2 or more salt-water sources turn into salt-water source.
* Entity tags for defining whether an aquatic mob can breath in saltwater and/or freshwater, causing saltwater only fish to "drown" in freshwater, and vice versa.
  * Applied to vanilla mobs, by default.
  * A mob can also breath in both if configured.
* Saltwater causes adjacent copper to oxidize faster.
* Saltwater can be "boiled" in cauldrons to get salt. Place a head source like lava, campfire, or a regular fire under the cauldron.
* Salt crafts into salt blocks.
* Salt blocks damage slime on contact (like salt on slugs and snails IRL). Use entity tags.
* Cows, Camel, and some other animals congregate to salt blocks.
  * Every once in a while they lick the salt which reduces their breeding timer and heals them. (In real life, they lick big salt blocks for sodium intake)
* Salt blocks adjacent to ice or snow instantly melts it
* Salt block adjacent to water will eventually turn the water into saltwater
* Salt + (item tag) saltable food = improved saturation
* Tridents travel further when thrown/traveling in salt-water VS regular water.
* Salt surrounding glowstone dust = Salt Lamp
* Dripstone with salt-water above it will create/grow salt crystals below it when dripping on salt block
* Butcher villager trades salt
