package com.booksofchance;

import com.booksofchance.config.Configuration;
import com.booksofchance.enchantment.CritDamageEnchantment;
import com.booksofchance.enchantment.CritRateEnchantment;
import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {
	public static final String MOD_ID = "books_of_chance";
	Configuration ConfigStart = new Configuration();
	public static CritRateEnchantment critRateEnchantment = new CritRateEnchantment();
	public static CritDamageEnchantment critDamageEnchantment = new CritDamageEnchantment();



	@Override
	public void onInitialize() {
		//Configuration
		if(Configuration.RATE_ENABLE) {
			Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "crit_rate"), critRateEnchantment);
		}
		if(Configuration.DAMAGE_ENABLE) {
			Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "crit_damage"), critDamageEnchantment);
		}
	}

}