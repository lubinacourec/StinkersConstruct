package slimeknights.tconstruct.library.utils;

import java.util.Arrays;

import net.minecraft.util.NonNullList;

public final class ListUtil
{

    public static <E> NonNullList<E> getListFrom(E... element)
    {
        NonNullList<E> list = NonNullList.create();
        list.addAll(Arrays.asList(element));
        return list;
    }

    private ListUtil() {}
}
