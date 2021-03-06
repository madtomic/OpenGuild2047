/*
 * Copyright 2014 Aleksander.
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
package com.github.grzegorz2047.openguild.hook;

import com.github.grzegorz2047.openguild.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Aleksander
 */
public abstract class Hook {
    private final Plugin bukkit;
    private final Logger logger;
    private final String plugin;
    
    public Hook(String plugin) {
        this.bukkit = Bukkit.getPluginManager().getPlugin(plugin);
        this.logger = new HookLogger(this);
        this.plugin = plugin;
    }
    
    public abstract void enable(Plugin plugin);
    
    public Plugin getBukkitPlugin() {
        return bukkit;
    }
    
    public Logger getLogger() {
        return logger;
    }
    
    public String getPlugin() {
        return plugin;
    }
    
    public boolean isEnabled() {
        return bukkit != null && bukkit.isEnabled();
    }
}
