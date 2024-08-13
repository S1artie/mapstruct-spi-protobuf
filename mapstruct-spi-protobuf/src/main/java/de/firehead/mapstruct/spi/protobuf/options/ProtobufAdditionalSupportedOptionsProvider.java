/* mapstruct-spi-protobuf
 *
 * Copyright (C) 2024
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package de.firehead.mapstruct.spi.protobuf.options;

import org.mapstruct.ap.spi.AdditionalSupportedOptionsProvider;

import java.util.Collections;
import java.util.Set;

/**
 * Options supported by this SPI implementation.
 *
 * @author Rene Schneider
 */
public class ProtobufAdditionalSupportedOptionsProvider implements AdditionalSupportedOptionsProvider {

    /**
     * Option to configure the automatic mapping of the UNRECOGNIZED enum value generated for Protobuf enums. By default
     * this is TRUE, which means that the UNRECOGNIZED value is automatically mapped to null.
     * <p>
     * Typically this value is mapped to null, just like the _UNSPECIFIED value, which works fine if mapping Protobuf
     * enums to Java enums. However there may be reasons to map this value explicitly. For example in case of
     * Protobuf-to-Protobuf mappings, mapping both of these Proto-specific values to null causes the problem of
     * _UNSPECIFIED not being mapped to _UNSPECIFIED of the other enum, but to UNRECOGNIZED. This option allows to
     * disable the automatic mapping of UNRECOGNIZED to null, which fixes the issue in case of Protobuf-to-Protobuf
     * mappings (UNRECOGNIZED then maps to the UNRECOGNIZED value in the other enum), but causes missing mappings in
     * all Protobuf-to-Java cases.
     */
    public static final String MAP_UNRECOGNIZED_TO_NULL = "protobuf.enum.mapUnrecognizedToNull";

    @Override
    public Set<String> getAdditionalSupportedOptions() {
        return Collections.singleton(MAP_UNRECOGNIZED_TO_NULL);
    }
}
