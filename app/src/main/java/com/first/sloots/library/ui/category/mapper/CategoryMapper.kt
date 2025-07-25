package com.first.sloots.library.ui.category.mapper

import com.first.sloots.library.data.db.entity.CategoryEntity
import com.first.sloots.library.data.network.model.category.ListsItem
import com.first.sloots.library.ui.category.model.CategoryDM

fun ListsItem.toDomain(lastDate: String?): CategoryDM? {
    return this.takeIf {
        !displayName.isNullOrEmpty() && !listNameEncoded.isNullOrEmpty()
    }?.let{
        CategoryDM(this.displayName,lastDate ,this.listNameEncoded)
    }

}

fun CategoryDM.toCategoryEntity(): CategoryEntity {
    return CategoryEntity(
        idKey = this.listNameEncoded.toString(),
        name = this.displayName.toString(),
        lastDate = this.lastDate.orEmpty()
    )
}

fun CategoryEntity.toDomain(): CategoryDM {
    return CategoryDM(
        displayName = this.name,
        lastDate = this.lastDate,
        listNameEncoded = this.idKey.toString()
    )
}


