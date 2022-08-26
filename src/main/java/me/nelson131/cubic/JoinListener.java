package me.nelson131.cubic;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.dependencies.jda.api.entities.Member;
import github.scarsz.discordsrv.dependencies.jda.api.entities.Role;
import github.scarsz.discordsrv.dependencies.jda.api.entities.User;
import github.scarsz.discordsrv.util.DiscordUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static me.nelson131.cubic.Cubic.plugin;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        String roleid = plugin.getConfig().getString("roleid");
        String guildid = plugin.getConfig().getString("guildid");


        String discordId = DiscordSRV.getPlugin().getAccountLinkManager().getDiscordId(event.getPlayer().getUniqueId());
        Role role = DiscordUtil.getJda().getRoleById(roleid);
        Member member = DiscordUtil.getJda().getGuildById(guildid).getMemberById(discordId);

        member.getJDA().getGuildById(guildid).addRoleToMember(member, role).queue();
    }
}
