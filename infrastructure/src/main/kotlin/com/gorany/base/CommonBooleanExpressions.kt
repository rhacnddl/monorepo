package com.gorany.base

import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.core.types.dsl.BooleanPath
import com.querydsl.core.types.dsl.Expressions

object CommonBooleanExpressions {
    fun isNotDeleted(isDeleted: BooleanPath): BooleanExpression = Expressions.asBoolean(isDeleted).isFalse
}
