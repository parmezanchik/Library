package com.first.sloots.library.ui.category.mapper

import com.first.sloots.library.data.network.model.category.ListsItem
import com.first.sloots.library.ui.category.model.CategoryDM

fun ListsItem.toDomain(lastDate: String?): CategoryDM? {
    return this.takeIf {
        !displayName.isNullOrEmpty() && !listNameEncoded.isNullOrEmpty()
    }?.let{
        CategoryDM(this.displayName,lastDate ,this.listNameEncoded)
    }

}

