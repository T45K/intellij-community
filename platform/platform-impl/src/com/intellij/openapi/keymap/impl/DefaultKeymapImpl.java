/*
 * Copyright 2000-2016 JetBrains s.r.o.
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
package com.intellij.openapi.keymap.impl

import com.intellij.openapi.actionSystem.IdeActions
import com.intellij.openapi.actionSystem.MouseShortcut
import com.intellij.openapi.keymap.Keymap
import com.intellij.openapi.keymap.KeymapManager
import com.intellij.openapi.util.SystemInfo
import org.jdom.Element

import java.awt.event.MouseEvent

open class DefaultKeymapImpl : KeymapImpl() {
  override fun canModify() = false

  override fun getPresentableName() = DefaultKeymap.getInstance().getKeymapPresentableName(this)

  override fun readExternal(keymapElement: Element, existingKeymaps: Array<Keymap>) {
    super.readExternal(keymapElement, existingKeymaps)

    if (KeymapManager.DEFAULT_IDEA_KEYMAP == name && !SystemInfo.isXWindow) {
      addShortcut(IdeActions.ACTION_GOTO_DECLARATION, MouseShortcut(MouseEvent.BUTTON2, 0, 1))
    }
  }
}
