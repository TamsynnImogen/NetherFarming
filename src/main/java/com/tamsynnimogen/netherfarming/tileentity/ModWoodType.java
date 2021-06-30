package com.tamsynnimogen.netherfarming.tileentity;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import java.util.Set;
import java.util.stream.Stream;

public class ModWoodType {
   private static final Set<ModWoodType> VALUES = new ObjectArraySet<>();
   public static final ModWoodType OAK = register(new ModWoodType("oak"));
   public static final ModWoodType BLOODBARK = register(new ModWoodType("bloodbark"));

   private final String name;

   protected ModWoodType(String nameIn) {
      this.name = nameIn;
   }

   public static ModWoodType register(ModWoodType woodTypeIn) {
      VALUES.add(woodTypeIn);
      return woodTypeIn;
   }

   public static Stream<ModWoodType> getValues() {
      return VALUES.stream();
   }

   public String getName() {
      return this.name;
   }

   /**
    * Use this to create a new {@link ModWoodType}. Make sure to register its rendering by enqueuing Atlases.addWoodType(...) during client setup..
    */
   public static ModWoodType create(String name) {
      return new ModWoodType(name);
   }
}