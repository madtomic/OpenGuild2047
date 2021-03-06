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

package pl.grzegorz2047.openguild2047.commands.guild;

import com.github.grzegorz2047.openguild.command.Command;
import com.github.grzegorz2047.openguild.command.CommandException;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import pl.grzegorz2047.openguild2047.GenConf;
import pl.grzegorz2047.openguild2047.managers.MsgManager;

/**
 * This command shows list of 'guild' command sub-commands.
 * 
 * Usage: /guild help
 */
public class GuildHelpCommand extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) throws CommandException {
        int page = 1;
        if(args.length != 2) {
            page = 1;
        } else {
            if(args[1].equalsIgnoreCase("admin") || args[1].equalsIgnoreCase("a")) {
                admin(sender);
                return;
            }
            try {
                page = Integer.parseInt(args[1]);
            } catch(NumberFormatException ex) {
                sender.sendMessage(MsgManager.get("pagenotnumber"));
            }
        }
        
        sender.sendMessage(getHelpTitle(page));
        
        if(page == 1) {
            if(GenConf.lang.equals("PL")) {
                sender.sendMessage(help("zaloz <tag> [opis...]", "Zaloz gildie"));
                sender.sendMessage(help("zapros <gracz>", "Zapros gracza do gildii"));
                sender.sendMessage(help("akceptuj <tag>", "Akceptuj zaproszenie od gildii"));
                sender.sendMessage(help("opis [ustaw <opis...>]", "Stwórz lub zobacz opis gildii"));
                sender.sendMessage(help("lider <gracz>", "Oddaj lidera gildii innemu graczowi"));
                sender.sendMessage(help("akceptuj <gildia>", "Akceptuje dolaczenie do gildii"));
                sender.sendMessage(help("opusc", "Opusc gildie w której teraz jestes"));
                sender.sendMessage(help("info <gildia>", "Informacje o gildii"));
                sender.sendMessage(help("sojusz <gildia>", "Ustawienie sojuszu z inna gildia"));
                sender.sendMessage(help("wrog <gildia>", "Zerwanie z inna gildia"));
                sender.sendMessage(help("zamknij", "Zamknij gildie"));
                sender.sendMessage(help("wyrzuc <gracz>", "Wyrzuca czlonka gildii"));
                sender.sendMessage(help("itemy", "Lista itemów na gildie"));
                sender.sendMessage(help("dom", "Teleportuj sie do gildii"));
                sender.sendMessage(help("lista", "Lista wszystkich  gildii"));
                sender.sendMessage(help("help [admin|strona]", "Pokaz pomoc [admin/strona]"));
            } else {
                sender.sendMessage(help("create <tag> [desc...]", "Create guild"));
                sender.sendMessage(help("invite <player>", "Accepts invite to joint guild"));
                sender.sendMessage(help("accept <guild>", "Accept invite to joint guild"));
                sender.sendMessage(help("description [set <description...>]", "Change or see description of guild"));
                sender.sendMessage(help("leader <gracz>", "Give leader to someone else"));
                sender.sendMessage(help("invite", "Invite to guild (sends invite)"));
                sender.sendMessage(help("leave", "Leave from current guild"));
                sender.sendMessage(help("info <guild>", "Information about the guild"));
                sender.sendMessage(help("ally <guild>", "Create an alliance"));
                sender.sendMessage(help("enemy <guild>", "Broke an alliance"));
                sender.sendMessage(help("disband", "Disband your guild"));
                sender.sendMessage(help("items", "List of required items"));
                sender.sendMessage(help("home", "Teleport to your guild home location"));
                sender.sendMessage(help("list", "List all guilds"));
                sender.sendMessage(help("kick <player>", "Kicks member of guild"));
                sender.sendMessage(help("help [admin|page]", "Show help [admin/page]"));
            }
        } else {
            sender.sendMessage(MsgManager.get("pagenotfound", "&cStrona o numerze &7{NUMBER}&c nie zostala odnaleziona").replace("{NUMBER}", String.valueOf(page)));
        }
    }

    private String getHelpTitle(int page) {
        return this.getTitle(ChatColor.GOLD + "Help (" + page + "/1)");
    }

    private String help(String usage, String desc) {
        if(GenConf.lang.equals("PL")){
            return ChatColor.GREEN +  "/gildia " + ChatColor.AQUA + usage + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + desc;
        } else {
            return ChatColor.GREEN + "/guild " + ChatColor.AQUA + usage + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + desc;
        }
        
    }

    private void admin(CommandSender sender) {
        int hide = 0;
        sender.sendMessage(this.getTitle(ChatColor.GOLD + "Help Admin"));
        sender.sendMessage(help("reload", "Przeladuj konfiguracje pluginu"));
        if(GenConf.hcBans) {
            sender.sendMessage(help("unban <player>", "Odbanuj gracza"));
        } else {
            hide++;
        }
        sender.sendMessage(help("version", "Informacje o plugine OpenGuild2047"));
        
        if(hide > 0) {
            sender.sendMessage(MsgManager.get("skipped").replace("{HELP}", String.valueOf(hide)));
        }
    }

    @Override
    public int minArgs() {
        return 1;
    }

}
