package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AccompanistLibraryAccessors laccForAccompanistLibraryAccessors = new AccompanistLibraryAccessors(owner);
    private final AndroidLibraryAccessors laccForAndroidLibraryAccessors = new AndroidLibraryAccessors(owner);
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final ComposeLibraryAccessors laccForComposeLibraryAccessors = new ComposeLibraryAccessors(owner);
    private final ConcurrentLibraryAccessors laccForConcurrentLibraryAccessors = new ConcurrentLibraryAccessors(owner);
    private final FuelLibraryAccessors laccForFuelLibraryAccessors = new FuelLibraryAccessors(owner);
    private final KotlinLibraryAccessors laccForKotlinLibraryAccessors = new KotlinLibraryAccessors(owner);
    private final KtorLibraryAccessors laccForKtorLibraryAccessors = new KtorLibraryAccessors(owner);
    private final WearLibraryAccessors laccForWearLibraryAccessors = new WearLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

        /**
         * Creates a dependency provider for guava (com.google.guava:guava)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGuava() {
            return create("guava");
    }

    /**
     * Returns the group of libraries at accompanist
     */
    public AccompanistLibraryAccessors getAccompanist() {
        return laccForAccompanistLibraryAccessors;
    }

    /**
     * Returns the group of libraries at android
     */
    public AndroidLibraryAccessors getAndroid() {
        return laccForAndroidLibraryAccessors;
    }

    /**
     * Returns the group of libraries at androidx
     */
    public AndroidxLibraryAccessors getAndroidx() {
        return laccForAndroidxLibraryAccessors;
    }

    /**
     * Returns the group of libraries at compose
     */
    public ComposeLibraryAccessors getCompose() {
        return laccForComposeLibraryAccessors;
    }

    /**
     * Returns the group of libraries at concurrent
     */
    public ConcurrentLibraryAccessors getConcurrent() {
        return laccForConcurrentLibraryAccessors;
    }

    /**
     * Returns the group of libraries at fuel
     */
    public FuelLibraryAccessors getFuel() {
        return laccForFuelLibraryAccessors;
    }

    /**
     * Returns the group of libraries at kotlin
     */
    public KotlinLibraryAccessors getKotlin() {
        return laccForKotlinLibraryAccessors;
    }

    /**
     * Returns the group of libraries at ktor
     */
    public KtorLibraryAccessors getKtor() {
        return laccForKtorLibraryAccessors;
    }

    /**
     * Returns the group of libraries at wear
     */
    public WearLibraryAccessors getWear() {
        return laccForWearLibraryAccessors;
    }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class AccompanistLibraryAccessors extends SubDependencyFactory {

        public AccompanistLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for permissions (com.google.accompanist:accompanist-permissions)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPermissions() {
                return create("accompanist.permissions");
        }

    }

    public static class AndroidLibraryAccessors extends SubDependencyFactory {
        private final AndroidLintLibraryAccessors laccForAndroidLintLibraryAccessors = new AndroidLintLibraryAccessors(owner);

        public AndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at android.lint
         */
        public AndroidLintLibraryAccessors getLint() {
            return laccForAndroidLintLibraryAccessors;
        }

    }

    public static class AndroidLintLibraryAccessors extends SubDependencyFactory {

        public AndroidLintLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for gradle (com.android.tools.lint:lint-gradle)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getGradle() {
                return create("android.lint.gradle");
        }

    }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxActivityLibraryAccessors laccForAndroidxActivityLibraryAccessors = new AndroidxActivityLibraryAccessors(owner);
        private final AndroidxHealthLibraryAccessors laccForAndroidxHealthLibraryAccessors = new AndroidxHealthLibraryAccessors(owner);
        private final AndroidxLifecycleLibraryAccessors laccForAndroidxLifecycleLibraryAccessors = new AndroidxLifecycleLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.activity
         */
        public AndroidxActivityLibraryAccessors getActivity() {
            return laccForAndroidxActivityLibraryAccessors;
        }

        /**
         * Returns the group of libraries at androidx.health
         */
        public AndroidxHealthLibraryAccessors getHealth() {
            return laccForAndroidxHealthLibraryAccessors;
        }

        /**
         * Returns the group of libraries at androidx.lifecycle
         */
        public AndroidxLifecycleLibraryAccessors getLifecycle() {
            return laccForAndroidxLifecycleLibraryAccessors;
        }

    }

    public static class AndroidxActivityLibraryAccessors extends SubDependencyFactory {

        public AndroidxActivityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.activity:activity-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() {
                return create("androidx.activity.compose");
        }

    }

    public static class AndroidxHealthLibraryAccessors extends SubDependencyFactory {

        public AndroidxHealthLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for services (androidx.health:health-services-client)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getServices() {
                return create("androidx.health.services");
        }

    }

    public static class AndroidxLifecycleLibraryAccessors extends SubDependencyFactory {
        private final AndroidxLifecycleViewmodelLibraryAccessors laccForAndroidxLifecycleViewmodelLibraryAccessors = new AndroidxLifecycleViewmodelLibraryAccessors(owner);

        public AndroidxLifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.lifecycle.viewmodel
         */
        public AndroidxLifecycleViewmodelLibraryAccessors getViewmodel() {
            return laccForAndroidxLifecycleViewmodelLibraryAccessors;
        }

    }

    public static class AndroidxLifecycleViewmodelLibraryAccessors extends SubDependencyFactory {

        public AndroidxLifecycleViewmodelLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.lifecycle:lifecycle-viewmodel-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() {
                return create("androidx.lifecycle.viewmodel.compose");
        }

    }

    public static class ComposeLibraryAccessors extends SubDependencyFactory {
        private final ComposeMaterialLibraryAccessors laccForComposeMaterialLibraryAccessors = new ComposeMaterialLibraryAccessors(owner);
        private final ComposeUiLibraryAccessors laccForComposeUiLibraryAccessors = new ComposeUiLibraryAccessors(owner);

        public ComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compiler (androidx.compose.compiler:compiler)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompiler() {
                return create("compose.compiler");
        }

        /**
         * Returns the group of libraries at compose.material
         */
        public ComposeMaterialLibraryAccessors getMaterial() {
            return laccForComposeMaterialLibraryAccessors;
        }

        /**
         * Returns the group of libraries at compose.ui
         */
        public ComposeUiLibraryAccessors getUi() {
            return laccForComposeUiLibraryAccessors;
        }

    }

    public static class ComposeMaterialLibraryAccessors extends SubDependencyFactory {
        private final ComposeMaterialIconsLibraryAccessors laccForComposeMaterialIconsLibraryAccessors = new ComposeMaterialIconsLibraryAccessors(owner);

        public ComposeMaterialLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at compose.material.icons
         */
        public ComposeMaterialIconsLibraryAccessors getIcons() {
            return laccForComposeMaterialIconsLibraryAccessors;
        }

    }

    public static class ComposeMaterialIconsLibraryAccessors extends SubDependencyFactory {

        public ComposeMaterialIconsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for extended (androidx.compose.material:material-icons-extended)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getExtended() {
                return create("compose.material.icons.extended");
        }

    }

    public static class ComposeUiLibraryAccessors extends SubDependencyFactory {
        private final ComposeUiToolingLibraryAccessors laccForComposeUiToolingLibraryAccessors = new ComposeUiToolingLibraryAccessors(owner);

        public ComposeUiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at compose.ui.tooling
         */
        public ComposeUiToolingLibraryAccessors getTooling() {
            return laccForComposeUiToolingLibraryAccessors;
        }

    }

    public static class ComposeUiToolingLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ComposeUiToolingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for tooling (androidx.compose.ui:ui-tooling)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("compose.ui.tooling");
        }

            /**
             * Creates a dependency provider for preview (androidx.compose.ui:ui-tooling-preview)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPreview() {
                return create("compose.ui.tooling.preview");
        }

    }

    public static class ConcurrentLibraryAccessors extends SubDependencyFactory {

        public ConcurrentLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for futures (androidx.concurrent:concurrent-futures-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getFutures() {
                return create("concurrent.futures");
        }

    }

    public static class FuelLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public FuelLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for fuel (com.github.kittinunf.fuel:fuel)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("fuel");
        }

            /**
             * Creates a dependency provider for coroutines (com.github.kittinunf.fuel:fuel-coroutines)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCoroutines() {
                return create("fuel.coroutines");
        }

    }

    public static class KotlinLibraryAccessors extends SubDependencyFactory {
        private final KotlinGradleLibraryAccessors laccForKotlinGradleLibraryAccessors = new KotlinGradleLibraryAccessors(owner);

        public KotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at kotlin.gradle
         */
        public KotlinGradleLibraryAccessors getGradle() {
            return laccForKotlinGradleLibraryAccessors;
        }

    }

    public static class KotlinGradleLibraryAccessors extends SubDependencyFactory {

        public KotlinGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (org.jetbrains.kotlin:kotlin-gradle-plugin)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() {
                return create("kotlin.gradle.plugin");
        }

    }

    public static class KtorLibraryAccessors extends SubDependencyFactory {
        private final KtorClientLibraryAccessors laccForKtorClientLibraryAccessors = new KtorClientLibraryAccessors(owner);

        public KtorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at ktor.client
         */
        public KtorClientLibraryAccessors getClient() {
            return laccForKtorClientLibraryAccessors;
        }

    }

    public static class KtorClientLibraryAccessors extends SubDependencyFactory {

        public KtorClientLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for android (io.ktor:ktor-client-android)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() {
                return create("ktor.client.android");
        }

            /**
             * Creates a dependency provider for core (io.ktor:ktor-client-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("ktor.client.core");
        }

            /**
             * Creates a dependency provider for logging (io.ktor:ktor-client-logging)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getLogging() {
                return create("ktor.client.logging");
        }

            /**
             * Creates a dependency provider for serialization (io.ktor:ktor-client-serialization)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSerialization() {
                return create("ktor.client.serialization");
        }

    }

    public static class WearLibraryAccessors extends SubDependencyFactory {
        private final WearComposeLibraryAccessors laccForWearComposeLibraryAccessors = new WearComposeLibraryAccessors(owner);

        public WearLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at wear.compose
         */
        public WearComposeLibraryAccessors getCompose() {
            return laccForWearComposeLibraryAccessors;
        }

    }

    public static class WearComposeLibraryAccessors extends SubDependencyFactory {

        public WearComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for foundation (androidx.wear.compose:compose-foundation)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getFoundation() {
                return create("wear.compose.foundation");
        }

            /**
             * Creates a dependency provider for material (androidx.wear.compose:compose-material)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMaterial() {
                return create("wear.compose.material");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final AccompanistVersionAccessors vaccForAccompanistVersionAccessors = new AccompanistVersionAccessors(providers, config);
        private final AndroidVersionAccessors vaccForAndroidVersionAccessors = new AndroidVersionAccessors(providers, config);
        private final AndroidxVersionAccessors vaccForAndroidxVersionAccessors = new AndroidxVersionAccessors(providers, config);
        private final ComposeVersionAccessors vaccForComposeVersionAccessors = new ComposeVersionAccessors(providers, config);
        private final ConcurrentVersionAccessors vaccForConcurrentVersionAccessors = new ConcurrentVersionAccessors(providers, config);
        private final HealthVersionAccessors vaccForHealthVersionAccessors = new HealthVersionAccessors(providers, config);
        private final KtorVersionAccessors vaccForKtorVersionAccessors = new KtorVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: fuel (3.0.0-alpha1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getFuel() { return getVersion("fuel"); }

            /**
             * Returns the version associated to this alias: guava (32.1.3-android)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGuava() { return getVersion("guava"); }

            /**
             * Returns the version associated to this alias: ktlint (0.46.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKtlint() { return getVersion("ktlint"); }

        /**
         * Returns the group of versions at versions.accompanist
         */
        public AccompanistVersionAccessors getAccompanist() {
            return vaccForAccompanistVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.android
         */
        public AndroidVersionAccessors getAndroid() {
            return vaccForAndroidVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.androidx
         */
        public AndroidxVersionAccessors getAndroidx() {
            return vaccForAndroidxVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.compose
         */
        public ComposeVersionAccessors getCompose() {
            return vaccForComposeVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.concurrent
         */
        public ConcurrentVersionAccessors getConcurrent() {
            return vaccForConcurrentVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.health
         */
        public HealthVersionAccessors getHealth() {
            return vaccForHealthVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.ktor
         */
        public KtorVersionAccessors getKtor() {
            return vaccForKtorVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class AccompanistVersionAccessors extends VersionFactory  {

        public AccompanistVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: accompanist.permissions (0.32.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getPermissions() { return getVersion("accompanist.permissions"); }

    }

    public static class AndroidVersionAccessors extends VersionFactory  {

        private final AndroidGradleVersionAccessors vaccForAndroidGradleVersionAccessors = new AndroidGradleVersionAccessors(providers, config);
        public AndroidVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.android.gradle
         */
        public AndroidGradleVersionAccessors getGradle() {
            return vaccForAndroidGradleVersionAccessors;
        }

    }

    public static class AndroidGradleVersionAccessors extends VersionFactory  {

        public AndroidGradleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: android.gradle.plugin (8.1.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getPlugin() { return getVersion("android.gradle.plugin"); }

    }

    public static class AndroidxVersionAccessors extends VersionFactory  {

        private final AndroidxWearVersionAccessors vaccForAndroidxWearVersionAccessors = new AndroidxWearVersionAccessors(providers, config);
        public AndroidxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidx.activity (1.8.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getActivity() { return getVersion("androidx.activity"); }

            /**
             * Returns the version associated to this alias: androidx.lifecycle (2.6.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLifecycle() { return getVersion("androidx.lifecycle"); }

        /**
         * Returns the group of versions at versions.androidx.wear
         */
        public AndroidxWearVersionAccessors getWear() {
            return vaccForAndroidxWearVersionAccessors;
        }

    }

    public static class AndroidxWearVersionAccessors extends VersionFactory  {

        public AndroidxWearVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidx.wear.compose (1.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCompose() { return getVersion("androidx.wear.compose"); }

    }

    public static class ComposeVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public ComposeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: compose (1.5.3)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("compose"); }

            /**
             * Returns the version associated to this alias: compose.compiler (1.5.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCompiler() { return getVersion("compose.compiler"); }

    }

    public static class ConcurrentVersionAccessors extends VersionFactory  {

        public ConcurrentVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: concurrent.futures (1.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getFutures() { return getVersion("concurrent.futures"); }

    }

    public static class HealthVersionAccessors extends VersionFactory  {

        public HealthVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: health.services (1.0.0-rc01)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getServices() { return getVersion("health.services"); }

    }

    public static class KtorVersionAccessors extends VersionFactory  {

        public KtorVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: ktor.version (1.6.8)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getVersion() { return getVersion("ktor.version"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgJetbrainsVersionAccessors vaccForOrgJetbrainsVersionAccessors = new OrgJetbrainsVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.jetbrains
         */
        public OrgJetbrainsVersionAccessors getJetbrains() {
            return vaccForOrgJetbrainsVersionAccessors;
        }

    }

    public static class OrgJetbrainsVersionAccessors extends VersionFactory  {

        public OrgJetbrainsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.jetbrains.kotlin (1.9.10)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlin() { return getVersion("org.jetbrains.kotlin"); }

            /**
             * Returns the version associated to this alias: org.jetbrains.kotlinx (1.6.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlinx() { return getVersion("org.jetbrains.kotlinx"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {
        private final ComPluginAccessors paccForComPluginAccessors = new ComPluginAccessors(providers, config);
        private final OrgPluginAccessors paccForOrgPluginAccessors = new OrgPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com
         */
        public ComPluginAccessors getCom() {
            return paccForComPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.org
         */
        public OrgPluginAccessors getOrg() {
            return paccForOrgPluginAccessors;
        }

    }

    public static class ComPluginAccessors extends PluginFactory {
        private final ComAndroidPluginAccessors paccForComAndroidPluginAccessors = new ComAndroidPluginAccessors(providers, config);
        private final ComDiffplugPluginAccessors paccForComDiffplugPluginAccessors = new ComDiffplugPluginAccessors(providers, config);

        public ComPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com.android
         */
        public ComAndroidPluginAccessors getAndroid() {
            return paccForComAndroidPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.com.diffplug
         */
        public ComDiffplugPluginAccessors getDiffplug() {
            return paccForComDiffplugPluginAccessors;
        }

    }

    public static class ComAndroidPluginAccessors extends PluginFactory {

        public ComAndroidPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for com.android.application to the plugin id 'com.android.application'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getApplication() { return createPlugin("com.android.application"); }

    }

    public static class ComDiffplugPluginAccessors extends PluginFactory {

        public ComDiffplugPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for com.diffplug.spotless to the plugin id 'com.diffplug.spotless'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getSpotless() { return createPlugin("com.diffplug.spotless"); }

    }

    public static class OrgPluginAccessors extends PluginFactory {
        private final OrgJetbrainsPluginAccessors paccForOrgJetbrainsPluginAccessors = new OrgJetbrainsPluginAccessors(providers, config);

        public OrgPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.org.jetbrains
         */
        public OrgJetbrainsPluginAccessors getJetbrains() {
            return paccForOrgJetbrainsPluginAccessors;
        }

    }

    public static class OrgJetbrainsPluginAccessors extends PluginFactory {
        private final OrgJetbrainsKotlinPluginAccessors paccForOrgJetbrainsKotlinPluginAccessors = new OrgJetbrainsKotlinPluginAccessors(providers, config);

        public OrgJetbrainsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.org.jetbrains.kotlin
         */
        public OrgJetbrainsKotlinPluginAccessors getKotlin() {
            return paccForOrgJetbrainsKotlinPluginAccessors;
        }

    }

    public static class OrgJetbrainsKotlinPluginAccessors extends PluginFactory {

        public OrgJetbrainsKotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for org.jetbrains.kotlin.android to the plugin id 'org.jetbrains.kotlin.android'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getAndroid() { return createPlugin("org.jetbrains.kotlin.android"); }

    }

}
