/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.idm.engine.impl.persistence.entity.data.impl;

import java.util.List;

import org.activiti.idm.engine.IdmEngineConfiguration;
import org.activiti.idm.engine.impl.persistence.entity.ByteArrayEntity;
import org.activiti.idm.engine.impl.persistence.entity.ByteArrayEntityImpl;
import org.activiti.idm.engine.impl.persistence.entity.data.AbstractDataManager;
import org.activiti.idm.engine.impl.persistence.entity.data.ByteArrayDataManager;

/**
 * @author Joram Barrez
 */
public class MybatisByteArrayDataManager extends AbstractDataManager<ByteArrayEntity> implements ByteArrayDataManager {
  
  public MybatisByteArrayDataManager(IdmEngineConfiguration idmEngineConfiguration) {
    super(idmEngineConfiguration);
  }

  @Override
  public ByteArrayEntity create() {
    return new ByteArrayEntityImpl();
  }

  @Override
  public Class<? extends ByteArrayEntity> getManagedEntityClass() {
    return ByteArrayEntityImpl.class;
  }
  
  @Override
  @SuppressWarnings("unchecked")
  public List<ByteArrayEntity> findAll() {
    return getDbSqlSession().selectList("selectByteArrays");
  }
  
  @Override
  public void deleteByteArrayNoRevisionCheck(String byteArrayEntityId) {
    getDbSqlSession().delete("deleteByteArrayNoRevisionCheck", byteArrayEntityId);
  }
  
}
