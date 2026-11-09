package koala.saline.tags;

import koala.Saline;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class SalineTags {
    //TODO rethink tags
    public static final TagKey<EntityType<?>> SALTWATER = TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Saline.MODID, "saltwater"));
    public static final TagKey<EntityType<?>> BOTHWATER = TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Saline.MODID, "bothwater"));
    public static final TagKey<EntityType<?>> GETS_HURT_BY_SALT = TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Saline.MODID, "gets_hurt_by_salt"));
}
