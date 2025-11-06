/*
 * Copyright 2025 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.libraries.matrix.api.room.accountdata

import kotlinx.collections.immutable.ImmutableMap

sealed interface RoomAccountDataEvent {
    /**
     * m.fully_read
     */
    data class FullyRead(val eventId: String) : RoomAccountDataEvent
    /**
     * m.marked_unread
     */
    data class MarkedUnread(val unread: Boolean) : RoomAccountDataEvent
    /**
     * m.tag
     */
    data class Tag(val tags: ImmutableMap<TagName, TagInfo>) : RoomAccountDataEvent
    /**
     * com.famedly.marked_unread
     */
    data class UnstableMarkedUnread(val unread: Boolean) : RoomAccountDataEvent

    /**
     * The event type.
     */
    val type: RoomAccountDataEventType
        get() {
            return when (this) {
                is FullyRead -> RoomAccountDataEventType.FULLY_READ
                is MarkedUnread -> RoomAccountDataEventType.MARKED_UNREAD
                is Tag -> RoomAccountDataEventType.TAG
                is UnstableMarkedUnread -> RoomAccountDataEventType.UNSTABLE_MARKED_UNREAD
            }
        }
}
