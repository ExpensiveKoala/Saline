package koala.saline.data;

import koala.Saline;
import koala.saline.tags.SalineTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class SalineEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public SalineEntityTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper existingFileHelper) {
        super(output, provider, Saline.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
//        tag(SalineTags.SALTWATER)
//                .add(EntityType.SQUID)
//                .add(EntityType.GLOW_SQUID)
//                .add(EntityType.TROPICAL_FISH)
//                .add(EntityType.PUFFERFISH)
//                .add(EntityType.COD);
//
//        tag(SalineTags.BOTHWATER)
//                .add(EntityType.SALMON);

        tag(SalineTags.GETS_HURT_BY_SALT)
                .add(EntityType.SLIME);
    }
}
