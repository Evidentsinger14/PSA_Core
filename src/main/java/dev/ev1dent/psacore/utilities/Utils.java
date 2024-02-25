package dev.ev1dent.psacore.utilities;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class Utils {

    public Component formatMM(String s){
        return MiniMessage.miniMessage().deserialize(s);
    }
}
