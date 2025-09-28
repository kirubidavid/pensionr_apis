package com.genesysafrica.pensionr.organization;

import java.util.UUID;

public record UserOrganizationMappingEvent(UUID vUserName, UUID vOrgId, UUID vCreatedBy) {
}
