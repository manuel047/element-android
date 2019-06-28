/*
 * Copyright 2019 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.riotredesign.features.home.room.detail.timeline.action

import android.graphics.Typeface
import android.widget.TextView
import androidx.core.view.isVisible
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import im.vector.riotredesign.R
import im.vector.riotredesign.core.epoxy.VectorEpoxyHolder

/**
 * Item displaying an emoji reaction (single line with emoji, author, time)
 */
@EpoxyModelClass(layout = R.layout.item_simple_reaction_info)
abstract class ReactionInfoSimpleItem : EpoxyModelWithHolder<ReactionInfoSimpleItem.Holder>() {

    @EpoxyAttribute
    lateinit var reactionKey: CharSequence
    @EpoxyAttribute
    lateinit var authorDisplayName: CharSequence
    @EpoxyAttribute
    var timeStamp: CharSequence? = null

    @EpoxyAttribute
    var emojiTypeFace: Typeface? = null

    override fun bind(holder: Holder) {
        holder.emojiReactionView.text = reactionKey
        holder.emojiReactionView.typeface = emojiTypeFace ?: Typeface.DEFAULT
        holder.displayNameView.text = authorDisplayName
        timeStamp?.let {
            holder.timeStampView.text = it
            holder.timeStampView.isVisible = true
        } ?: run {
            holder.timeStampView.isVisible = false
        }
    }

    class Holder : VectorEpoxyHolder() {
        val emojiReactionView by bind<TextView>(R.id.itemSimpleReactionInfoKey)
        val displayNameView by bind<TextView>(R.id.itemSimpleReactionInfoMemberName)
        val timeStampView by bind<TextView>(R.id.itemSimpleReactionInfoTime)
    }

}
