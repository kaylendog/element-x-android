/*
 * Copyright 2025 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.libraries.matrix.api.room.accountdata

enum class RoomAccountDataEventType {
    /**
     * m.fully_read
     */
    FULLY_READ,
    /**
     * m.marked_unread
     */
    MARKED_UNREAD,
    /**
     * m.tag
     */
    TAG,
    /**
     * com.famedly.marked_unread
     */
    UNSTABLE_MARKED_UNREAD;
}
