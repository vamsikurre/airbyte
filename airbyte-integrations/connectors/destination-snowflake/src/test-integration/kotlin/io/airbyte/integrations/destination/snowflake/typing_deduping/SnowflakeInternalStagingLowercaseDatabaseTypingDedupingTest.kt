/*
 * Copyright (c) 2023 Airbyte, Inc., all rights reserved.
 */
package io.airbyte.integrations.destination.snowflake.typing_deduping

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode
import io.airbyte.cdk.db.jdbc.JdbcUtils
import java.sql.SQLException
import java.util.*

class SnowflakeInternalStagingLowercaseDatabaseTypingDedupingTest :
    AbstractSnowflakeTypingDedupingTest() {
    override val configPath: String
        get() = "secrets/1s1t_internal_staging_config.json"

    /**
     * Verify that even if the config has a lowercase database name, we're able to run syncs
     * successfully. This is a regression test for a bug where we were not upcasing the database
     * name when checking for an existing final table.
     */
    @Throws(SQLException::class)
    override fun generateConfig(): JsonNode {
        val config = super.generateConfig()
        (config as ObjectNode).put(
            JdbcUtils.DATABASE_KEY,
            config.get(JdbcUtils.DATABASE_KEY).asText().lowercase(Locale.getDefault())
        )
        return config
    }
}
