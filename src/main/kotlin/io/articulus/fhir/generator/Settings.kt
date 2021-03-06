package io.articulus.fhir.generator

class Settings {
    companion object {
        /**
         * http://hl7.org/fhir is the latest release. To generate other versions go to
         * http://hl7.org/fhir/directory.html and select which version to use.
         */
        const val baseUrl = "http://hl7.org/fhir/"
        const val modelVersion = "dstu3"

        val downloadFiles = (System.getenv("downloadFiles") ?: "false").equals("true", true)

        const val baseModelPackage = "io.articulus.fhir.model"
        const val downloadDir = "./download"
        private const val destinationBaseDir = "."
        const val destinationSrcDir = "$destinationBaseDir/src/main/kotlin"
        const val destinationTestDir = "$destinationBaseDir/src/test/kotlin"
        const val samplesDir = "$destinationBaseDir/src/test/resources/model/sample_data/$modelVersion"

        val reservedMap = mapOf(
                "for" to "for_fhir",
                "from" to "from_fhir",
                "class" to "class_fhir",
                "import" to "import_fhir",
                "global" to "global_fhir",
                "assert" to "assert_fhir",
                "when" to "when_fhir",
                "package" to "package_fhir"
        )

        val  classMap = mapOf(
                "Any" to "Resource",
                "Practitioner.role" to "PractRole",  // to avoid Practitioner.role and PractitionerRole generating the same class
                "bool" to "Boolean",
                "integer" to "Int",
                "positiveint" to "Int",
                "unsignedint" to "Int",
                "date" to "String",
                "datetime" to "String",
                "instant" to "String",
                "time" to "String",
                "decimal" to "Float",
                "markdown" to "String",
                "id" to "String",
                "code" to "String",
                "uri" to "String",
                "url" to "String",
                "canonical" to "String",
                "oid" to "String",
                "uuid" to "String",
                "xhtml" to "String",
                "base64binary" to "String"
        )


        val primitives = listOf(
                "String",
                "Int",
                "Boolean",
                "Float",
                "FhirDate"
        )

        val enumNameMap = mapOf(
                "httpto//hl7.org/fhir/contracttermsubtypecodes" to "ContractTermSubtypeCodes",
                "httpto//hl7.org/fhir/coverage-exception" to "CoverageExceptionCodes",
                "httpto//hl7.org/fhir/resource-type-link" to "ResourceTypeLink"
        )

        val jsonmap = mapOf(
                "str" to "String",
                "int" to "Int",
                "bool" to "Boolean",
                "float" to "Float"
        )

        const val jsonMapDefault = "dict"

        // Which class names are native to the language (or can be treated this way)
        val natives = listOf("Int", "Float", "Boolean", "String", "List",
                "LocalDateTime", "FhirDate")

        val defaultValues = mapOf(
                "String" to """""""",
                "Boolean" to "false",
                "Int" to "0",
                "Float" to "0.0f",
                "LocalDate" to "LocalDate.now()",
                "LocalDateTime" to "LocalDateTime.now()",
                "FhirDate" to "FhirDate.now()"
        )

        val manualClasses = mapOf(
                "FhirAbstractResource" to mapOf(
                        "resourceType" to Pair("String?", "null")
                )
        )

    }
}

