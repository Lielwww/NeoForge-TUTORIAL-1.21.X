package net.liel.tutorialmod.item;

import net.liel.tutorialmod.TutorialMod;
import net.liel.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final Supplier<CreativeModeTab> DIDDY_ITEMS_TAB = CREATIVE_MODE_TAB.register("diddy_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BABYOIL.get()))
                    .title(Component.translatable("creativetab.tutorialmod.diddy_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BABYOIL);
                        output.accept(ModItems.TOY);


                    }).build());

    public static final Supplier<CreativeModeTab> DIDDY_BLOCK_TAB = CREATIVE_MODE_TAB.register("diddy_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.DIDDY_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "diddy_items_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.diddy_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                      output.accept(ModBlocks.DIDDY_BLOCK);
                      output.accept(ModBlocks.BABYOIL_BLOCK);


                    }).build());

    public static void register(IEventBus eventBus) {
     CREATIVE_MODE_TAB.register(eventBus);
    }
}
