package io.articulus.fhir.generator

import com.google.gson.GsonBuilder
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import io.google.gson.typeadapters.RuntimeTypeAdapterFactory
import java.io.File


open class FhirRenderer(val spec: FhirSpec) {
    fun build() {
        FhirStructureDefinitionRenderer(spec).render()
        TestClassRenderer(spec)
        renderUtilityClass(spec)
    }

    private fun renderUtilityClass(spec: FhirSpec) {
        val out = FileSpec.builder(Settings.baseModelPackage, "Utility")

        val resClass = ClassName(spec.packageName, "Resource")

        out.addFunction(FunSpec.builder("gsonFhirBuilder")
                .returns(GsonBuilder::class.java)
                .addCode("""
                    val runtimeTypeAdapterFactory = %T
                        .of(%T::class.java, "resourceType", true);
                    return io.articulus.fhir.base.gsonFhirGeneratorBuilder()
                        .registerTypeAdapterFactory(runtimeTypeAdapterFactory)

                """.trimIndent(), RuntimeTypeAdapterFactory::class.java, resClass)
                .build())

        out.build().writeTo(File("${Settings.destinationSrcDir}"))
    }

}


