/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.idm.engine.impl.interceptor;

import org.activiti.idm.engine.IdmEngineConfiguration;

/**
 * @author Tijs Rademakers
 */
public class CommandContextFactory {

  protected IdmEngineConfiguration dmnEngineConfiguration;

  public CommandContext createCommandContext(Command<?> cmd) {
    return new CommandContext(cmd, dmnEngineConfiguration);
  }

  // getters and setters
  // //////////////////////////////////////////////////////

  public IdmEngineConfiguration getDmnEngineConfiguration() {
    return dmnEngineConfiguration;
  }

  public void setDmnEngineConfiguration(IdmEngineConfiguration dmnEngineConfiguration) {
    this.dmnEngineConfiguration = dmnEngineConfiguration;
  }
}