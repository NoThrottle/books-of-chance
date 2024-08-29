package com.booksofchance.config;
import com.booksofchance.config.SimpleConfig.ConfigRequest;
import net.minecraft.enchantment.Enchantment;

import java.util.Random;

public class Configuration {
    public static int RATE_MAXLEVEL;
    public static int RATE_RARITY;
    public static double RATE_IPL;
    public static boolean RATE_ENABLE;
    public static double RATE_COOLDOWN;
    public static double RATE_BASE;

    public static int DAMAGE_MAXLEVEL;
    public static int DAMAGE_RARITY;
    public static double DAMAGE_BASE;
    public static double DAMAGE_IPL;
    public static boolean DAMAGE_ENABLE;


    public static Random myRandom = new Random();

    public SimpleConfig CONFIG;
    public Configuration() {
        ConfigRequest requester = SimpleConfig.of("BooksOfChance");
        requester.provider(this::provider);
        CONFIG = requester.request();
        readConfig();
    }


    private String provider( String filename ) {
        return "crit_rate.rarity=1  #The larger the number, the rarer it is. There are a total of four levels.(1-4)\n" +
                "crit_rate.max_level=5\n" +
                "crit_rate.increase_per_level=0.2  #The initial additional crit rate is 0.\n" +
                "crit_rate.enable=true\n"+
                "crit_rate.cooldown=0.9 #this is in seconds\n"+
                "crit_rate.base=0.05 #The initial crit rate for unenchanted tools.\n"+
                "\n" +
                "crit_damage.rarity=3\n" +
                "crit_damage.max_level=3\n" +
                "crit_damage.initial_effect=1.5\n" +
                "crit_damage.increase_per_level=0.5\n" +
                "crit_damage.enable=true"
                ;
    }

    public void readConfig(){
        RATE_MAXLEVEL = CONFIG.getOrDefault("crit_rate.max_level",5);
        RATE_RARITY = CONFIG.getOrDefault("crit_rate.rarity",2);
        RATE_IPL = CONFIG.getOrDefault("crit_rate.increase_per_level",0.2);
        RATE_ENABLE = CONFIG.getOrDefault("crit_rate.enable",true);
        RATE_COOLDOWN = CONFIG.getOrDefault("crit_rate.cooldown",0.9);
        RATE_BASE = CONFIG.getOrDefault("crit_rate.base",0.05);

        DAMAGE_MAXLEVEL = CONFIG.getOrDefault("crit_damage.max_level",3);
        DAMAGE_RARITY = CONFIG.getOrDefault("crit_damage.rarity",3);
        DAMAGE_BASE = CONFIG.getOrDefault("crit_damage.initial_effect",1.5);
        DAMAGE_IPL = CONFIG.getOrDefault("crit_damage.increase_per_level",0.5);
        DAMAGE_ENABLE = CONFIG.getOrDefault("crit_damage.enable",true);

    }

    public static Enchantment.Rarity setRarity(int number){
        return switch (number) {
            case 1 -> Enchantment.Rarity.COMMON;
            case 3 -> Enchantment.Rarity.RARE;
            case 4 -> Enchantment.Rarity.VERY_RARE;
            default -> Enchantment.Rarity.UNCOMMON;
        };
    }
}
