package slimeknights.tconstruct.library.client.material.deserializers;

import slimeknights.tconstruct.library.client.MaterialRenderInfo;

public class InverseMultiColorRenderInfoDeserializer extends MultiColorRenderInfoDeserializer
{

    @Override
    public MaterialRenderInfo getMaterialRenderInfo()
    {
        return new MaterialRenderInfo.InverseMultiColor(fromHex(dark), fromHex(mid), fromHex(bright));
    }
}
