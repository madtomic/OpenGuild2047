/*
 * Copyright 2014
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.grzegorz2047.openguild;

import org.bukkit.Location;
import org.bukkit.util.Vector;

/**
 *
 * @author Grzegorz
 */
public class Cuboid {

    private Location center;
    private int radius;
    private String owner;

    public Location getCenter() {
        return this.center;
    }

    public int getRadius() {
        return this.radius;
    }

    public boolean isinCuboid(Location loc) {
        Vector v = loc.toVector();
        return v.isInAABB(this.getMin().toVector(), this.getMax().toVector());
    }

    public void setCenter(Location center) {
        this.center = center;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String tag) {
        this.owner = tag;
    }

    public Location getMin() {
        return new Location(this.center.getWorld(), this.center.getBlockX() - this.radius, 0, this.center.getBlockZ() - this.radius);
    }

    public Location getMax() {
        return new Location(this.center.getWorld(), this.center.getBlockX() + this.radius, this.center.getWorld().getMaxHeight(), this.center.getBlockZ() + this.radius);
    }

}
