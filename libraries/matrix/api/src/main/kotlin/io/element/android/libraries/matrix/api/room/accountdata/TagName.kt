/*
 * Copyright 2025 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.libraries.matrix.api.room.accountdata

/**
 * The name of a tag.
 */
interface TagName {
    /**
     * `m.favourite`: The user's favorite rooms.
     */
    object Favorite : TagName

    /**
     * `m.lowpriority`: These should be shown with lower precedence than
     * others.
     */
    object LowPriority : TagName

    /**
     * `m.server_notice`: Used to identify
     */
    object ServerNotice : TagName

    /**
     * `u.*`: User-defined tag
     */
    data class User(val value: String) : TagName
}
