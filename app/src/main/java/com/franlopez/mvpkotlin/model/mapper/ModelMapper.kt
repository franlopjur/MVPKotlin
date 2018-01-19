package com.franlopez.mvpkotlin.model.mapper

import com.franlopez.mvpkotlin.model.ItemModel
import com.franlopez.mvpkotlin.model.dto.ItemDTO

class ModelMapper {
    fun transform(items: List<ItemDTO>): List<ItemModel> {
        return items.map { transform(it) }
    }

    fun transform(item: ItemDTO): ItemModel {
        return ItemModel(item.item,
                item.business,
                item.farmerId,
                item.category,
                item.l,
                item.farmName,
                item.phone1)
    }
}


