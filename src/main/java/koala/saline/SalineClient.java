package koala.saline;

import koala.Saline;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = Saline.MODID, dist = Dist.CLIENT)
public class SalineClient {
    public SalineClient(ModContainer container) {
       container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
