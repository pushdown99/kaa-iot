/*
 * Copyright 2014-2016 CyberVision, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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

package org.kaaproject.kaa.server.common.dao.model.sql;

import static org.kaaproject.kaa.server.common.dao.DaoConstants.CTL_SCHEMA_META_INFO_APPLICATION_FK;
import static org.kaaproject.kaa.server.common.dao.DaoConstants.CTL_SCHEMA_META_INFO_APPLICATION_ID;
import static org.kaaproject.kaa.server.common.dao.DaoConstants.CTL_SCHEMA_META_INFO_FQN;
import static org.kaaproject.kaa.server.common.dao.DaoConstants.CTL_SCHEMA_META_INFO_TABLE_NAME;
import static org.kaaproject.kaa.server.common.dao.DaoConstants.CTL_SCHEMA_META_INFO_TENANT_FK;
import static org.kaaproject.kaa.server.common.dao.DaoConstants.CTL_SCHEMA_META_INFO_TENANT_ID;
import static org.kaaproject.kaa.server.common.dao.DaoConstants.CTL_SCHEMA_META_INFO_UNIQUE_CONSTRAINT;
import static org.kaaproject.kaa.server.common.dao.model.sql.ModelUtils.getLongId;

import org.kaaproject.kaa.common.dto.ctl.CtlSchemaMetaInfoDto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = CTL_SCHEMA_META_INFO_TABLE_NAME, uniqueConstraints =
    @UniqueConstraint(
      columnNames = {CTL_SCHEMA_META_INFO_FQN,
          CTL_SCHEMA_META_INFO_TENANT_ID, CTL_SCHEMA_META_INFO_APPLICATION_ID},
      name = CTL_SCHEMA_META_INFO_UNIQUE_CONSTRAINT
    )
)
public class CtlSchemaMetaInfo extends GenericModel<CtlSchemaMetaInfoDto> implements Serializable {

  private static final long serialVersionUID = 3185049875063895954L;

  @Column(name = CTL_SCHEMA_META_INFO_FQN)
  private String fqn;
  @ManyToOne(optional = true, fetch = FetchType.LAZY)
  @JoinColumn(nullable = true, name = CTL_SCHEMA_META_INFO_TENANT_ID,
      foreignKey = @ForeignKey(name = CTL_SCHEMA_META_INFO_TENANT_FK))
  private Tenant tenant;
  @ManyToOne(optional = true, fetch = FetchType.LAZY)
  @JoinColumn(nullable = true, name = CTL_SCHEMA_META_INFO_APPLICATION_ID,
      foreignKey = @ForeignKey(name = CTL_SCHEMA_META_INFO_APPLICATION_FK))
  private Application application;

  /**
   * Create new instance of CTL schema meta info.
   */
  public CtlSchemaMetaInfo() {
  }

  /**
   * Create new instance of CTL schema meta info.
   *
   * @param dto data transfer object that used for creating new instance,
   *            it hold id, full qualified name, tenant id and application id
   *            of new instance
   */
  public CtlSchemaMetaInfo(CtlSchemaMetaInfoDto dto) {
    this.id = ModelUtils.getLongId(dto.getId());
    this.fqn = dto.getFqn();
    Long tenantId = getLongId(dto.getTenantId());
    this.tenant = tenantId != null ? new Tenant(tenantId) : null;
    Long appId = getLongId(dto.getApplicationId());
    this.application = appId != null ? new Application(appId) : null;
  }

  /**
   * Create new instance of CTL schema meta info.
   * @param fqn is full qualified name
   */
  public CtlSchemaMetaInfo(String fqn) {
    this.fqn = fqn;
  }

  /**
   * Create new instance of CTL schema meta info.
   * @param fqn is full qualified name
   * @param tenantId is tenant id, it used for creating
   *                 <code>Tenant</code> with corresponding id and
   *                 set it on field <code>tenant</code>
   * @param applicationId is application id, it used for creating
   *                 <code>Application</code> with corresponding id and
   *                 set it on field <code>application</code>
   */
  public CtlSchemaMetaInfo(String fqn, String tenantId, String applicationId) {
    this.fqn = fqn;
    Long tenId = getLongId(tenantId);
    this.tenant = tenId != null ? new Tenant(tenId) : null;
    Long appId = getLongId(applicationId);
    this.application = appId != null ? new Application(appId) : null;
  }

  /**
   * Create new instance of CTL schema meta info.
   * @param fqn is full qualified name
   * @param tenant is <code>Tenant</code> instance
   * @param application is <code>Application</code> instance
   */
  public CtlSchemaMetaInfo(String fqn, Tenant tenant, Application application) {
    this.fqn = fqn;
    this.tenant = tenant;
    this.application = application;
  }

  public CtlSchemaMetaInfo(Long id) {
    this.id = id;
  }

  /**
   * Update fields <code>tenant</code> and <code>application</code>,
   * create new instances by using ids in parameters.
   * @param tenantId is tenant id
   * @param applicationId is application id
   */
  public void updateScope(String tenantId, String applicationId) {
    Long tenId = getLongId(tenantId);
    this.tenant = tenId != null ? new Tenant(tenId) : null;
    Long appId = getLongId(applicationId);
    this.application = appId != null ? new Application(appId) : null;
  }

  public String getFqn() {
    return fqn;
  }

  public void setFqn(String fqn) {
    this.fqn = fqn;
  }

  public Tenant getTenant() {
    return tenant;
  }

  public void setTenant(Tenant tenant) {
    this.tenant = tenant;
  }

  public Application getApplication() {
    return application;
  }

  public void setApplication(Application application) {
    this.application = application;
  }

  @Override
  protected CtlSchemaMetaInfoDto createDto() {
    return new CtlSchemaMetaInfoDto();
  }

  @Override
  protected GenericModel<CtlSchemaMetaInfoDto> newInstance(Long id) {
    return new CtlSchemaMetaInfo(id);
  }

  @Override
  public CtlSchemaMetaInfoDto toDto() {
    CtlSchemaMetaInfoDto ctlSchemaMetaInfoDto = createDto();
    ctlSchemaMetaInfoDto.setId(getStringId());
    ctlSchemaMetaInfoDto.setFqn(fqn);
    ctlSchemaMetaInfoDto.setApplicationId(application != null ? application.getStringId() : null);
    ctlSchemaMetaInfoDto.setTenantId(tenant != null ? tenant.getStringId() : null);
    return ctlSchemaMetaInfoDto;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((application == null) ? 0 : application.hashCode());
    result = prime * result + ((fqn == null) ? 0 : fqn.hashCode());
    result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    CtlSchemaMetaInfo other = (CtlSchemaMetaInfo) obj;
    if (application == null) {
      if (other.application != null) {
        return false;
      }
    } else if (!application.equals(other.application)) {
      return false;
    }
    if (fqn == null) {
      if (other.fqn != null) {
        return false;
      }
    } else if (!fqn.equals(other.fqn)) {
      return false;
    }
    if (tenant == null) {
      if (other.tenant != null) {
        return false;
      }
    } else if (!tenant.equals(other.tenant)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CtlSchemaMetaInfo [fqn=");
    builder.append(fqn);
    builder.append(", tenant=");
    builder.append(tenant);
    builder.append(", application=");
    builder.append(application);
    builder.append("]");
    return builder.toString();
  }

}
