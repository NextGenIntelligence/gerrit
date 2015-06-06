// Copyright (C) 2014 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.gerrit.extensions.events;

import com.google.gerrit.extensions.annotations.ExtensionPoint;

import java.util.Properties;

/**
 * Notified whenever the garbage collector has run successfully on a project.
 */
@ExtensionPoint
public interface GarbageCollectorListener {
  public interface Event {
    /** @return The name of the project that has been garbage collected. */
    String getProjectName();

    /**
     * @return Properties describing the result of the garbage collection
     *         performed by JGit.
     * @see <a href="http://download.eclipse.org/jgit/site/3.7.0.201502260915-r/apidocs/org/eclipse/jgit/api/GarbageCollectCommand.html#call%28%29">GarbageCollectCommand</a>
     */
    Properties getStatistics();
  }

  void onGarbageCollected(Event event);
}
