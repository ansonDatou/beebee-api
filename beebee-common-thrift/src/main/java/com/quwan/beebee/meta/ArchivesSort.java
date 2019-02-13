package com.quwan.beebee.meta;

/**
 * 文章分类
 */
public enum ArchivesSort {
    One(1, "推荐"),
    Two(2, "宫斗"),
    Three(3, "穿越"),
    Four(4, "夜话"),
    Five(5, "奇人"),
    Six(6, "异事");

    public int id;
    public String name;

    ArchivesSort(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 根据前端传来的值，获取文章分类
     */
    public static ArchivesSort getArchivesSort(int id) {
        for (ArchivesSort sort : ArchivesSort.values()) {
            if (sort.id == id) {
                return sort;
            }
        }

        return ArchivesSort.One;
    }
}
