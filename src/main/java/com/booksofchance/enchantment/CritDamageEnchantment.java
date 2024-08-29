package com.booksofchance.enchantment;

import com.booksofchance.config.Configuration;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class CritDamageEnchantment extends Enchantment {

    public CritDamageEnchantment() {
        super(Configuration.setRarity(Configuration.DAMAGE_RARITY), EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }
    @Override
    public int getMinPower(int level) {
        return 1 + 10 * (level - 1);
    }
    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }
    @Override
    public int getMaxLevel() {
        return Configuration.DAMAGE_MAXLEVEL;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        boolean isAccept = EnchantmentTarget.WEAPON.isAcceptableItem(stack.getItem())|| EnchantmentTarget.TRIDENT.isAcceptableItem(stack.getItem()) || (stack.getItem() instanceof AxeItem);
        return isAccept;
    }

}