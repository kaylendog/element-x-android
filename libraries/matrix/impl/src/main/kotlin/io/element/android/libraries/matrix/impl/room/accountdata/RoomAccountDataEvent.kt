/*
 * Copyright 2025 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.libraries.matrix.impl.room.accountdata

import io.element.android.libraries.matrix.api.room.accountdata.RoomAccountDataEvent
import io.element.android.libraries.matrix.api.room.accountdata.TagInfo
import io.element.android.libraries.matrix.api.room.accountdata.TagName
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.matrix.rustcomponents.sdk.RoomAccountDataEvent as InnerRoomAccountDataEvent
import org.matrix.rustcomponents.sdk.TagInfo as InnerTagInfo
import org.matrix.rustcomponents.sdk.TagName as InnerTagName

fun InnerRoomAccountDataEvent.map(): RoomAccountDataEvent {
    return when (this) {
        is InnerRoomAccountDataEvent.UnstableMarkedUnread -> RoomAccountDataEvent.UnstableMarkedUnread(this.unread)
        is InnerRoomAccountDataEvent.FullyReadEvent -> RoomAccountDataEvent.FullyRead(this.eventId)
        is InnerRoomAccountDataEvent.MarkedUnread -> RoomAccountDataEvent.MarkedUnread(this.unread)
        is InnerRoomAccountDataEvent.Tag -> RoomAccountDataEvent.Tag(this.tags.map())
    }
}

fun Map<InnerTagName, InnerTagInfo>.map(): ImmutableMap<TagName, TagInfo> {
    return this.entries.associate { (key, value) -> key.map() to value.map() }.toImmutableMap()
}

fun InnerTagName.map(): TagName {
    return when (this) {
        is InnerTagName.Favorite -> TagName.Favorite
        is InnerTagName.LowPriority -> TagName.LowPriority
        is InnerTagName.ServerNotice -> TagName.ServerNotice
        is InnerTagName.User -> TagName.User(this.name.name)
    }
}

fun InnerTagInfo.map(): TagInfo {
    return TagInfo(this.order)
}
