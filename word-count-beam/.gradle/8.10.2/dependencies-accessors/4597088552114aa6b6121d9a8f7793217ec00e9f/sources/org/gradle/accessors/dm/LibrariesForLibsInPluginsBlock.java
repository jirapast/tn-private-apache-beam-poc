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
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibsInPluginsBlock extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final JodaLibraryAccessors laccForJodaLibraryAccessors = new JodaLibraryAccessors(owner);
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibsInPluginsBlock(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>com</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public ComLibraryAccessors getCom() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForComLibraryAccessors;
    }

    /**
     * Group of libraries at <b>joda</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public JodaLibraryAccessors getJoda() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForJodaLibraryAccessors;
    }

    /**
     * Group of libraries at <b>junit</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public JunitLibraryAccessors getJunit() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForJunitLibraryAccessors;
    }

    /**
     * Group of libraries at <b>org</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public OrgLibraryAccessors getOrg() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForOrgLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public BundleAccessors getBundles() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleLibraryAccessors laccForComGoogleLibraryAccessors = new ComGoogleLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleLibraryAccessors getGoogle() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleApiLibraryAccessors laccForComGoogleApiLibraryAccessors = new ComGoogleApiLibraryAccessors(owner);
        private final ComGoogleApisLibraryAccessors laccForComGoogleApisLibraryAccessors = new ComGoogleApisLibraryAccessors(owner);
        private final ComGoogleHttpLibraryAccessors laccForComGoogleHttpLibraryAccessors = new ComGoogleHttpLibraryAccessors(owner);

        public ComGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.api</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleApiLibraryAccessors getApi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleApiLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.google.apis</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleApisLibraryAccessors getApis() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleApisLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.google.http</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleHttpLibraryAccessors getHttp() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleHttpLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleApiLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleApiClientLibraryAccessors laccForComGoogleApiClientLibraryAccessors = new ComGoogleApiClientLibraryAccessors(owner);

        public ComGoogleApiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.api.client</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleApiClientLibraryAccessors getClient() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleApiClientLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleApiClientLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleApiClientGoogleLibraryAccessors laccForComGoogleApiClientGoogleLibraryAccessors = new ComGoogleApiClientGoogleLibraryAccessors(owner);

        public ComGoogleApiClientLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.api.client.google</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleApiClientGoogleLibraryAccessors getGoogle() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleApiClientGoogleLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleApiClientGoogleLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleApiClientGoogleApiLibraryAccessors laccForComGoogleApiClientGoogleApiLibraryAccessors = new ComGoogleApiClientGoogleApiLibraryAccessors(owner);

        public ComGoogleApiClientGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.api.client.google.api</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleApiClientGoogleApiLibraryAccessors getApi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleApiClientGoogleApiLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleApiClientGoogleApiLibraryAccessors extends SubDependencyFactory {

        public ComGoogleApiClientGoogleApiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>client</b> with <b>com.google.api-client:google-api-client</b> coordinates and
         * with version reference <b>com.google.api.client.google.api.client</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getClient() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("com.google.api.client.google.api.client");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleApisLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleApisGoogleLibraryAccessors laccForComGoogleApisGoogleLibraryAccessors = new ComGoogleApisGoogleLibraryAccessors(owner);

        public ComGoogleApisLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.apis.google</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleApisGoogleLibraryAccessors getGoogle() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleApisGoogleLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleApisGoogleLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleApisGoogleApiLibraryAccessors laccForComGoogleApisGoogleApiLibraryAccessors = new ComGoogleApisGoogleApiLibraryAccessors(owner);

        public ComGoogleApisGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.apis.google.api</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleApisGoogleApiLibraryAccessors getApi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleApisGoogleApiLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleApisGoogleApiLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleApisGoogleApiServicesLibraryAccessors laccForComGoogleApisGoogleApiServicesLibraryAccessors = new ComGoogleApisGoogleApiServicesLibraryAccessors(owner);

        public ComGoogleApisGoogleApiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.apis.google.api.services</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleApisGoogleApiServicesLibraryAccessors getServices() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleApisGoogleApiServicesLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleApisGoogleApiServicesLibraryAccessors extends SubDependencyFactory {

        public ComGoogleApisGoogleApiServicesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>bigquery</b> with <b>com.google.apis:google-api-services-bigquery</b> coordinates and
         * with version reference <b>com.google.apis.google.api.services.bigquery</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getBigquery() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("com.google.apis.google.api.services.bigquery");
        }

        /**
         * Dependency provider for <b>pubsub</b> with <b>com.google.apis:google-api-services-pubsub</b> coordinates and
         * with version reference <b>com.google.apis.google.api.services.pubsub</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getPubsub() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("com.google.apis.google.api.services.pubsub");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleHttpLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleHttpClientLibraryAccessors laccForComGoogleHttpClientLibraryAccessors = new ComGoogleHttpClientLibraryAccessors(owner);

        public ComGoogleHttpLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.http.client</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleHttpClientLibraryAccessors getClient() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleHttpClientLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleHttpClientLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleHttpClientGoogleLibraryAccessors laccForComGoogleHttpClientGoogleLibraryAccessors = new ComGoogleHttpClientGoogleLibraryAccessors(owner);

        public ComGoogleHttpClientLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.http.client.google</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleHttpClientGoogleLibraryAccessors getGoogle() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleHttpClientGoogleLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleHttpClientGoogleLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleHttpClientGoogleHttpLibraryAccessors laccForComGoogleHttpClientGoogleHttpLibraryAccessors = new ComGoogleHttpClientGoogleHttpLibraryAccessors(owner);

        public ComGoogleHttpClientGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.http.client.google.http</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleHttpClientGoogleHttpLibraryAccessors getHttp() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleHttpClientGoogleHttpLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleHttpClientGoogleHttpLibraryAccessors extends SubDependencyFactory {

        public ComGoogleHttpClientGoogleHttpLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>client</b> with <b>com.google.http-client:google-http-client</b> coordinates and
         * with version reference <b>com.google.http.client.google.http.client</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getClient() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("com.google.http.client.google.http.client");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JodaLibraryAccessors extends SubDependencyFactory {
        private final JodaTimeLibraryAccessors laccForJodaTimeLibraryAccessors = new JodaTimeLibraryAccessors(owner);

        public JodaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>joda.time</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JodaTimeLibraryAccessors getTime() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJodaTimeLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JodaTimeLibraryAccessors extends SubDependencyFactory {
        private final JodaTimeJodaLibraryAccessors laccForJodaTimeJodaLibraryAccessors = new JodaTimeJodaLibraryAccessors(owner);

        public JodaTimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>joda.time.joda</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JodaTimeJodaLibraryAccessors getJoda() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJodaTimeJodaLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JodaTimeJodaLibraryAccessors extends SubDependencyFactory {

        public JodaTimeJodaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>time</b> with <b>joda-time:joda-time</b> coordinates and
         * with version reference <b>joda.time.joda.time</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getTime() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("joda.time.joda.time");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JunitLibraryAccessors extends SubDependencyFactory {

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit</b> with <b>junit:junit</b> coordinates and
         * with version reference <b>junit.junit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJunit() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("junit.junit");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLibraryAccessors laccForOrgApacheLibraryAccessors = new OrgApacheLibraryAccessors(owner);
        private final OrgHamcrestLibraryAccessors laccForOrgHamcrestLibraryAccessors = new OrgHamcrestLibraryAccessors(owner);
        private final OrgMockitoLibraryAccessors laccForOrgMockitoLibraryAccessors = new OrgMockitoLibraryAccessors(owner);
        private final OrgSlf4jLibraryAccessors laccForOrgSlf4jLibraryAccessors = new OrgSlf4jLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheLibraryAccessors getApache() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.hamcrest</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgHamcrestLibraryAccessors getHamcrest() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgHamcrestLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.mockito</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgMockitoLibraryAccessors getMockito() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgMockitoLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.slf4j</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSlf4jLibraryAccessors getSlf4j() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSlf4jLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheBeamLibraryAccessors laccForOrgApacheBeamLibraryAccessors = new OrgApacheBeamLibraryAccessors(owner);
        private final OrgApacheKafkaLibraryAccessors laccForOrgApacheKafkaLibraryAccessors = new OrgApacheKafkaLibraryAccessors(owner);

        public OrgApacheLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.beam</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheBeamLibraryAccessors getBeam() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheBeamLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.apache.kafka</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheKafkaLibraryAccessors getKafka() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheKafkaLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheBeamLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheBeamBeamLibraryAccessors laccForOrgApacheBeamBeamLibraryAccessors = new OrgApacheBeamBeamLibraryAccessors(owner);

        public OrgApacheBeamLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.beam.beam</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheBeamBeamLibraryAccessors getBeam() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheBeamBeamLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheBeamBeamLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheBeamBeamRunnersLibraryAccessors laccForOrgApacheBeamBeamRunnersLibraryAccessors = new OrgApacheBeamBeamRunnersLibraryAccessors(owner);
        private final OrgApacheBeamBeamSdksLibraryAccessors laccForOrgApacheBeamBeamSdksLibraryAccessors = new OrgApacheBeamBeamSdksLibraryAccessors(owner);

        public OrgApacheBeamBeamLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.beam.beam.runners</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheBeamBeamRunnersLibraryAccessors getRunners() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheBeamBeamRunnersLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.apache.beam.beam.sdks</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheBeamBeamSdksLibraryAccessors getSdks() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheBeamBeamSdksLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheBeamBeamRunnersLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheBeamBeamRunnersDirectLibraryAccessors laccForOrgApacheBeamBeamRunnersDirectLibraryAccessors = new OrgApacheBeamBeamRunnersDirectLibraryAccessors(owner);
        private final OrgApacheBeamBeamRunnersPortabilityLibraryAccessors laccForOrgApacheBeamBeamRunnersPortabilityLibraryAccessors = new OrgApacheBeamBeamRunnersPortabilityLibraryAccessors(owner);

        public OrgApacheBeamBeamRunnersLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.beam.beam.runners.direct</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheBeamBeamRunnersDirectLibraryAccessors getDirect() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheBeamBeamRunnersDirectLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.apache.beam.beam.runners.portability</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheBeamBeamRunnersPortabilityLibraryAccessors getPortability() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheBeamBeamRunnersPortabilityLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheBeamBeamRunnersDirectLibraryAccessors extends SubDependencyFactory {

        public OrgApacheBeamBeamRunnersDirectLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>java</b> with <b>org.apache.beam:beam-runners-direct-java</b> coordinates and
         * with version reference <b>org.apache.beam.beam.runners.direct.java</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJava() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.apache.beam.beam.runners.direct.java");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheBeamBeamRunnersPortabilityLibraryAccessors extends SubDependencyFactory {

        public OrgApacheBeamBeamRunnersPortabilityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>java</b> with <b>org.apache.beam:beam-runners-portability-java</b> coordinates and
         * with version reference <b>org.apache.beam.beam.runners.portability.java</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJava() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.apache.beam.beam.runners.portability.java");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheBeamBeamSdksLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheBeamBeamSdksJavaLibraryAccessors laccForOrgApacheBeamBeamSdksJavaLibraryAccessors = new OrgApacheBeamBeamSdksJavaLibraryAccessors(owner);

        public OrgApacheBeamBeamSdksLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.beam.beam.sdks.java</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheBeamBeamSdksJavaLibraryAccessors getJava() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheBeamBeamSdksJavaLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheBeamBeamSdksJavaLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheBeamBeamSdksJavaIoLibraryAccessors laccForOrgApacheBeamBeamSdksJavaIoLibraryAccessors = new OrgApacheBeamBeamSdksJavaIoLibraryAccessors(owner);
        private final OrgApacheBeamBeamSdksJavaMyextensionsLibraryAccessors laccForOrgApacheBeamBeamSdksJavaMyextensionsLibraryAccessors = new OrgApacheBeamBeamSdksJavaMyextensionsLibraryAccessors(owner);

        public OrgApacheBeamBeamSdksJavaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.apache.beam:beam-sdks-java-core</b> coordinates and
         * with version reference <b>org.apache.beam.beam.sdks.java.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCore() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.apache.beam.beam.sdks.java.core");
        }

        /**
         * Group of libraries at <b>org.apache.beam.beam.sdks.java.io</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheBeamBeamSdksJavaIoLibraryAccessors getIo() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheBeamBeamSdksJavaIoLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.apache.beam.beam.sdks.java.myextensions</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheBeamBeamSdksJavaMyextensionsLibraryAccessors getMyextensions() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheBeamBeamSdksJavaMyextensionsLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheBeamBeamSdksJavaIoLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheBeamBeamSdksJavaIoGoogleLibraryAccessors laccForOrgApacheBeamBeamSdksJavaIoGoogleLibraryAccessors = new OrgApacheBeamBeamSdksJavaIoGoogleLibraryAccessors(owner);

        public OrgApacheBeamBeamSdksJavaIoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>kafka</b> with <b>org.apache.beam:beam-sdks-java-io-kafka</b> coordinates and
         * with version reference <b>org.apache.beam.beam.sdks.java.io.kafka</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getKafka() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.apache.beam.beam.sdks.java.io.kafka");
        }

        /**
         * Group of libraries at <b>org.apache.beam.beam.sdks.java.io.google</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheBeamBeamSdksJavaIoGoogleLibraryAccessors getGoogle() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheBeamBeamSdksJavaIoGoogleLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheBeamBeamSdksJavaIoGoogleLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheBeamBeamSdksJavaIoGoogleCloudLibraryAccessors laccForOrgApacheBeamBeamSdksJavaIoGoogleCloudLibraryAccessors = new OrgApacheBeamBeamSdksJavaIoGoogleCloudLibraryAccessors(owner);

        public OrgApacheBeamBeamSdksJavaIoGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.beam.beam.sdks.java.io.google.cloud</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheBeamBeamSdksJavaIoGoogleCloudLibraryAccessors getCloud() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheBeamBeamSdksJavaIoGoogleCloudLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheBeamBeamSdksJavaIoGoogleCloudLibraryAccessors extends SubDependencyFactory {

        public OrgApacheBeamBeamSdksJavaIoGoogleCloudLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>platform</b> with <b>org.apache.beam:beam-sdks-java-io-google-cloud-platform</b> coordinates and
         * with version reference <b>org.apache.beam.beam.sdks.java.io.google.cloud.platform</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getPlatform() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.apache.beam.beam.sdks.java.io.google.cloud.platform");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheBeamBeamSdksJavaMyextensionsLibraryAccessors extends SubDependencyFactory {

        public OrgApacheBeamBeamSdksJavaMyextensionsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>python</b> with <b>org.apache.beam:beam-sdks-java-extensions-python</b> coordinates and
         * with version reference <b>org.apache.beam.beam.sdks.java.myextensions.python</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getPython() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.apache.beam.beam.sdks.java.myextensions.python");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheKafkaLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheKafkaKafkaLibraryAccessors laccForOrgApacheKafkaKafkaLibraryAccessors = new OrgApacheKafkaKafkaLibraryAccessors(owner);

        public OrgApacheKafkaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.kafka.kafka</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheKafkaKafkaLibraryAccessors getKafka() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheKafkaKafkaLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheKafkaKafkaLibraryAccessors extends SubDependencyFactory {

        public OrgApacheKafkaKafkaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>clients</b> with <b>org.apache.kafka:kafka-clients</b> coordinates and
         * with version reference <b>org.apache.kafka.kafka.clients</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getClients() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.apache.kafka.kafka.clients");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgHamcrestLibraryAccessors extends SubDependencyFactory {
        private final OrgHamcrestHamcrestLibraryAccessors laccForOrgHamcrestHamcrestLibraryAccessors = new OrgHamcrestHamcrestLibraryAccessors(owner);

        public OrgHamcrestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.hamcrest.hamcrest</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgHamcrestHamcrestLibraryAccessors getHamcrest() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgHamcrestHamcrestLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgHamcrestHamcrestLibraryAccessors extends SubDependencyFactory {

        public OrgHamcrestHamcrestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.hamcrest:hamcrest-core</b> coordinates and
         * with version reference <b>org.hamcrest.hamcrest.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCore() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.hamcrest.hamcrest.core");
        }

        /**
         * Dependency provider for <b>library</b> with <b>org.hamcrest:hamcrest-library</b> coordinates and
         * with version reference <b>org.hamcrest.hamcrest.library</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getLibrary() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.hamcrest.hamcrest.library");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgMockitoLibraryAccessors extends SubDependencyFactory {
        private final OrgMockitoMockitoLibraryAccessors laccForOrgMockitoMockitoLibraryAccessors = new OrgMockitoMockitoLibraryAccessors(owner);

        public OrgMockitoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mockito.mockito</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgMockitoMockitoLibraryAccessors getMockito() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgMockitoMockitoLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgMockitoMockitoLibraryAccessors extends SubDependencyFactory {

        public OrgMockitoMockitoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.mockito:mockito-core</b> coordinates and
         * with version reference <b>org.mockito.mockito.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCore() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.mockito.mockito.core");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSlf4jLibraryAccessors extends SubDependencyFactory {
        private final OrgSlf4jSlf4jLibraryAccessors laccForOrgSlf4jSlf4jLibraryAccessors = new OrgSlf4jSlf4jLibraryAccessors(owner);

        public OrgSlf4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.slf4j.slf4j</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSlf4jSlf4jLibraryAccessors getSlf4j() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSlf4jSlf4jLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSlf4jSlf4jLibraryAccessors extends SubDependencyFactory {

        public OrgSlf4jSlf4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>org.slf4j:slf4j-api</b> coordinates and
         * with version reference <b>org.slf4j.slf4j.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getApi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.slf4j.slf4j.api");
        }

        /**
         * Dependency provider for <b>jdk14</b> with <b>org.slf4j:slf4j-jdk14</b> coordinates and
         * with version reference <b>org.slf4j.slf4j.jdk14</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJdk14() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.slf4j.slf4j.jdk14");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final JodaVersionAccessors vaccForJodaVersionAccessors = new JodaVersionAccessors(providers, config);
        private final JunitVersionAccessors vaccForJunitVersionAccessors = new JunitVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com</b>
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.joda</b>
         */
        public JodaVersionAccessors getJoda() {
            return vaccForJodaVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.junit</b>
         */
        public JunitVersionAccessors getJunit() {
            return vaccForJunitVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org</b>
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComGoogleVersionAccessors vaccForComGoogleVersionAccessors = new ComGoogleVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google</b>
         */
        public ComGoogleVersionAccessors getGoogle() {
            return vaccForComGoogleVersionAccessors;
        }

    }

    public static class ComGoogleVersionAccessors extends VersionFactory  {

        private final ComGoogleApiVersionAccessors vaccForComGoogleApiVersionAccessors = new ComGoogleApiVersionAccessors(providers, config);
        private final ComGoogleApisVersionAccessors vaccForComGoogleApisVersionAccessors = new ComGoogleApisVersionAccessors(providers, config);
        private final ComGoogleHttpVersionAccessors vaccForComGoogleHttpVersionAccessors = new ComGoogleHttpVersionAccessors(providers, config);
        public ComGoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.api</b>
         */
        public ComGoogleApiVersionAccessors getApi() {
            return vaccForComGoogleApiVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.google.apis</b>
         */
        public ComGoogleApisVersionAccessors getApis() {
            return vaccForComGoogleApisVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.google.http</b>
         */
        public ComGoogleHttpVersionAccessors getHttp() {
            return vaccForComGoogleHttpVersionAccessors;
        }

    }

    public static class ComGoogleApiVersionAccessors extends VersionFactory  {

        private final ComGoogleApiClientVersionAccessors vaccForComGoogleApiClientVersionAccessors = new ComGoogleApiClientVersionAccessors(providers, config);
        public ComGoogleApiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.api.client</b>
         */
        public ComGoogleApiClientVersionAccessors getClient() {
            return vaccForComGoogleApiClientVersionAccessors;
        }

    }

    public static class ComGoogleApiClientVersionAccessors extends VersionFactory  {

        private final ComGoogleApiClientGoogleVersionAccessors vaccForComGoogleApiClientGoogleVersionAccessors = new ComGoogleApiClientGoogleVersionAccessors(providers, config);
        public ComGoogleApiClientVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.api.client.google</b>
         */
        public ComGoogleApiClientGoogleVersionAccessors getGoogle() {
            return vaccForComGoogleApiClientGoogleVersionAccessors;
        }

    }

    public static class ComGoogleApiClientGoogleVersionAccessors extends VersionFactory  {

        private final ComGoogleApiClientGoogleApiVersionAccessors vaccForComGoogleApiClientGoogleApiVersionAccessors = new ComGoogleApiClientGoogleApiVersionAccessors(providers, config);
        public ComGoogleApiClientGoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.api.client.google.api</b>
         */
        public ComGoogleApiClientGoogleApiVersionAccessors getApi() {
            return vaccForComGoogleApiClientGoogleApiVersionAccessors;
        }

    }

    public static class ComGoogleApiClientGoogleApiVersionAccessors extends VersionFactory  {

        public ComGoogleApiClientGoogleApiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.google.api.client.google.api.client</b> with value <b>2.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getClient() { return getVersion("com.google.api.client.google.api.client"); }

    }

    public static class ComGoogleApisVersionAccessors extends VersionFactory  {

        private final ComGoogleApisGoogleVersionAccessors vaccForComGoogleApisGoogleVersionAccessors = new ComGoogleApisGoogleVersionAccessors(providers, config);
        public ComGoogleApisVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.apis.google</b>
         */
        public ComGoogleApisGoogleVersionAccessors getGoogle() {
            return vaccForComGoogleApisGoogleVersionAccessors;
        }

    }

    public static class ComGoogleApisGoogleVersionAccessors extends VersionFactory  {

        private final ComGoogleApisGoogleApiVersionAccessors vaccForComGoogleApisGoogleApiVersionAccessors = new ComGoogleApisGoogleApiVersionAccessors(providers, config);
        public ComGoogleApisGoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.apis.google.api</b>
         */
        public ComGoogleApisGoogleApiVersionAccessors getApi() {
            return vaccForComGoogleApisGoogleApiVersionAccessors;
        }

    }

    public static class ComGoogleApisGoogleApiVersionAccessors extends VersionFactory  {

        private final ComGoogleApisGoogleApiServicesVersionAccessors vaccForComGoogleApisGoogleApiServicesVersionAccessors = new ComGoogleApisGoogleApiServicesVersionAccessors(providers, config);
        public ComGoogleApisGoogleApiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.apis.google.api.services</b>
         */
        public ComGoogleApisGoogleApiServicesVersionAccessors getServices() {
            return vaccForComGoogleApisGoogleApiServicesVersionAccessors;
        }

    }

    public static class ComGoogleApisGoogleApiServicesVersionAccessors extends VersionFactory  {

        public ComGoogleApisGoogleApiServicesVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.google.apis.google.api.services.bigquery</b> with value <b>v2-rev20240815-2.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBigquery() { return getVersion("com.google.apis.google.api.services.bigquery"); }

        /**
         * Version alias <b>com.google.apis.google.api.services.pubsub</b> with value <b>v1-rev20220904-2.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPubsub() { return getVersion("com.google.apis.google.api.services.pubsub"); }

    }

    public static class ComGoogleHttpVersionAccessors extends VersionFactory  {

        private final ComGoogleHttpClientVersionAccessors vaccForComGoogleHttpClientVersionAccessors = new ComGoogleHttpClientVersionAccessors(providers, config);
        public ComGoogleHttpVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.http.client</b>
         */
        public ComGoogleHttpClientVersionAccessors getClient() {
            return vaccForComGoogleHttpClientVersionAccessors;
        }

    }

    public static class ComGoogleHttpClientVersionAccessors extends VersionFactory  {

        private final ComGoogleHttpClientGoogleVersionAccessors vaccForComGoogleHttpClientGoogleVersionAccessors = new ComGoogleHttpClientGoogleVersionAccessors(providers, config);
        public ComGoogleHttpClientVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.http.client.google</b>
         */
        public ComGoogleHttpClientGoogleVersionAccessors getGoogle() {
            return vaccForComGoogleHttpClientGoogleVersionAccessors;
        }

    }

    public static class ComGoogleHttpClientGoogleVersionAccessors extends VersionFactory  {

        private final ComGoogleHttpClientGoogleHttpVersionAccessors vaccForComGoogleHttpClientGoogleHttpVersionAccessors = new ComGoogleHttpClientGoogleHttpVersionAccessors(providers, config);
        public ComGoogleHttpClientGoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.http.client.google.http</b>
         */
        public ComGoogleHttpClientGoogleHttpVersionAccessors getHttp() {
            return vaccForComGoogleHttpClientGoogleHttpVersionAccessors;
        }

    }

    public static class ComGoogleHttpClientGoogleHttpVersionAccessors extends VersionFactory  {

        public ComGoogleHttpClientGoogleHttpVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.google.http.client.google.http.client</b> with value <b>1.44.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getClient() { return getVersion("com.google.http.client.google.http.client"); }

    }

    public static class JodaVersionAccessors extends VersionFactory  {

        private final JodaTimeVersionAccessors vaccForJodaTimeVersionAccessors = new JodaTimeVersionAccessors(providers, config);
        public JodaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.joda.time</b>
         */
        public JodaTimeVersionAccessors getTime() {
            return vaccForJodaTimeVersionAccessors;
        }

    }

    public static class JodaTimeVersionAccessors extends VersionFactory  {

        private final JodaTimeJodaVersionAccessors vaccForJodaTimeJodaVersionAccessors = new JodaTimeJodaVersionAccessors(providers, config);
        public JodaTimeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.joda.time.joda</b>
         */
        public JodaTimeJodaVersionAccessors getJoda() {
            return vaccForJodaTimeJodaVersionAccessors;
        }

    }

    public static class JodaTimeJodaVersionAccessors extends VersionFactory  {

        public JodaTimeJodaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>joda.time.joda.time</b> with value <b>2.10.14</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTime() { return getVersion("joda.time.joda.time"); }

    }

    public static class JunitVersionAccessors extends VersionFactory  {

        public JunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>junit.junit</b> with value <b>4.13.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunit() { return getVersion("junit.junit"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgApacheVersionAccessors vaccForOrgApacheVersionAccessors = new OrgApacheVersionAccessors(providers, config);
        private final OrgHamcrestVersionAccessors vaccForOrgHamcrestVersionAccessors = new OrgHamcrestVersionAccessors(providers, config);
        private final OrgMockitoVersionAccessors vaccForOrgMockitoVersionAccessors = new OrgMockitoVersionAccessors(providers, config);
        private final OrgSlf4jVersionAccessors vaccForOrgSlf4jVersionAccessors = new OrgSlf4jVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache</b>
         */
        public OrgApacheVersionAccessors getApache() {
            return vaccForOrgApacheVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.hamcrest</b>
         */
        public OrgHamcrestVersionAccessors getHamcrest() {
            return vaccForOrgHamcrestVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.mockito</b>
         */
        public OrgMockitoVersionAccessors getMockito() {
            return vaccForOrgMockitoVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.slf4j</b>
         */
        public OrgSlf4jVersionAccessors getSlf4j() {
            return vaccForOrgSlf4jVersionAccessors;
        }

    }

    public static class OrgApacheVersionAccessors extends VersionFactory  {

        private final OrgApacheBeamVersionAccessors vaccForOrgApacheBeamVersionAccessors = new OrgApacheBeamVersionAccessors(providers, config);
        private final OrgApacheKafkaVersionAccessors vaccForOrgApacheKafkaVersionAccessors = new OrgApacheKafkaVersionAccessors(providers, config);
        public OrgApacheVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.beam</b>
         */
        public OrgApacheBeamVersionAccessors getBeam() {
            return vaccForOrgApacheBeamVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.apache.kafka</b>
         */
        public OrgApacheKafkaVersionAccessors getKafka() {
            return vaccForOrgApacheKafkaVersionAccessors;
        }

    }

    public static class OrgApacheBeamVersionAccessors extends VersionFactory  {

        private final OrgApacheBeamBeamVersionAccessors vaccForOrgApacheBeamBeamVersionAccessors = new OrgApacheBeamBeamVersionAccessors(providers, config);
        public OrgApacheBeamVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.beam.beam</b>
         */
        public OrgApacheBeamBeamVersionAccessors getBeam() {
            return vaccForOrgApacheBeamBeamVersionAccessors;
        }

    }

    public static class OrgApacheBeamBeamVersionAccessors extends VersionFactory  {

        private final OrgApacheBeamBeamRunnersVersionAccessors vaccForOrgApacheBeamBeamRunnersVersionAccessors = new OrgApacheBeamBeamRunnersVersionAccessors(providers, config);
        private final OrgApacheBeamBeamSdksVersionAccessors vaccForOrgApacheBeamBeamSdksVersionAccessors = new OrgApacheBeamBeamSdksVersionAccessors(providers, config);
        public OrgApacheBeamBeamVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.beam.beam.runners</b>
         */
        public OrgApacheBeamBeamRunnersVersionAccessors getRunners() {
            return vaccForOrgApacheBeamBeamRunnersVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.apache.beam.beam.sdks</b>
         */
        public OrgApacheBeamBeamSdksVersionAccessors getSdks() {
            return vaccForOrgApacheBeamBeamSdksVersionAccessors;
        }

    }

    public static class OrgApacheBeamBeamRunnersVersionAccessors extends VersionFactory  {

        private final OrgApacheBeamBeamRunnersDirectVersionAccessors vaccForOrgApacheBeamBeamRunnersDirectVersionAccessors = new OrgApacheBeamBeamRunnersDirectVersionAccessors(providers, config);
        private final OrgApacheBeamBeamRunnersPortabilityVersionAccessors vaccForOrgApacheBeamBeamRunnersPortabilityVersionAccessors = new OrgApacheBeamBeamRunnersPortabilityVersionAccessors(providers, config);
        public OrgApacheBeamBeamRunnersVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.beam.beam.runners.direct</b>
         */
        public OrgApacheBeamBeamRunnersDirectVersionAccessors getDirect() {
            return vaccForOrgApacheBeamBeamRunnersDirectVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.apache.beam.beam.runners.portability</b>
         */
        public OrgApacheBeamBeamRunnersPortabilityVersionAccessors getPortability() {
            return vaccForOrgApacheBeamBeamRunnersPortabilityVersionAccessors;
        }

    }

    public static class OrgApacheBeamBeamRunnersDirectVersionAccessors extends VersionFactory  {

        public OrgApacheBeamBeamRunnersDirectVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.beam.beam.runners.direct.java</b> with value <b>2.60.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJava() { return getVersion("org.apache.beam.beam.runners.direct.java"); }

    }

    public static class OrgApacheBeamBeamRunnersPortabilityVersionAccessors extends VersionFactory  {

        public OrgApacheBeamBeamRunnersPortabilityVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.beam.beam.runners.portability.java</b> with value <b>2.60.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJava() { return getVersion("org.apache.beam.beam.runners.portability.java"); }

    }

    public static class OrgApacheBeamBeamSdksVersionAccessors extends VersionFactory  {

        private final OrgApacheBeamBeamSdksJavaVersionAccessors vaccForOrgApacheBeamBeamSdksJavaVersionAccessors = new OrgApacheBeamBeamSdksJavaVersionAccessors(providers, config);
        public OrgApacheBeamBeamSdksVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.beam.beam.sdks.java</b>
         */
        public OrgApacheBeamBeamSdksJavaVersionAccessors getJava() {
            return vaccForOrgApacheBeamBeamSdksJavaVersionAccessors;
        }

    }

    public static class OrgApacheBeamBeamSdksJavaVersionAccessors extends VersionFactory  {

        private final OrgApacheBeamBeamSdksJavaIoVersionAccessors vaccForOrgApacheBeamBeamSdksJavaIoVersionAccessors = new OrgApacheBeamBeamSdksJavaIoVersionAccessors(providers, config);
        private final OrgApacheBeamBeamSdksJavaMyextensionsVersionAccessors vaccForOrgApacheBeamBeamSdksJavaMyextensionsVersionAccessors = new OrgApacheBeamBeamSdksJavaMyextensionsVersionAccessors(providers, config);
        public OrgApacheBeamBeamSdksJavaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.beam.beam.sdks.java.core</b> with value <b>2.60.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("org.apache.beam.beam.sdks.java.core"); }

        /**
         * Group of versions at <b>versions.org.apache.beam.beam.sdks.java.io</b>
         */
        public OrgApacheBeamBeamSdksJavaIoVersionAccessors getIo() {
            return vaccForOrgApacheBeamBeamSdksJavaIoVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.apache.beam.beam.sdks.java.myextensions</b>
         */
        public OrgApacheBeamBeamSdksJavaMyextensionsVersionAccessors getMyextensions() {
            return vaccForOrgApacheBeamBeamSdksJavaMyextensionsVersionAccessors;
        }

    }

    public static class OrgApacheBeamBeamSdksJavaIoVersionAccessors extends VersionFactory  {

        private final OrgApacheBeamBeamSdksJavaIoGoogleVersionAccessors vaccForOrgApacheBeamBeamSdksJavaIoGoogleVersionAccessors = new OrgApacheBeamBeamSdksJavaIoGoogleVersionAccessors(providers, config);
        public OrgApacheBeamBeamSdksJavaIoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.beam.beam.sdks.java.io.kafka</b> with value <b>2.60.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKafka() { return getVersion("org.apache.beam.beam.sdks.java.io.kafka"); }

        /**
         * Group of versions at <b>versions.org.apache.beam.beam.sdks.java.io.google</b>
         */
        public OrgApacheBeamBeamSdksJavaIoGoogleVersionAccessors getGoogle() {
            return vaccForOrgApacheBeamBeamSdksJavaIoGoogleVersionAccessors;
        }

    }

    public static class OrgApacheBeamBeamSdksJavaIoGoogleVersionAccessors extends VersionFactory  {

        private final OrgApacheBeamBeamSdksJavaIoGoogleCloudVersionAccessors vaccForOrgApacheBeamBeamSdksJavaIoGoogleCloudVersionAccessors = new OrgApacheBeamBeamSdksJavaIoGoogleCloudVersionAccessors(providers, config);
        public OrgApacheBeamBeamSdksJavaIoGoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.beam.beam.sdks.java.io.google.cloud</b>
         */
        public OrgApacheBeamBeamSdksJavaIoGoogleCloudVersionAccessors getCloud() {
            return vaccForOrgApacheBeamBeamSdksJavaIoGoogleCloudVersionAccessors;
        }

    }

    public static class OrgApacheBeamBeamSdksJavaIoGoogleCloudVersionAccessors extends VersionFactory  {

        public OrgApacheBeamBeamSdksJavaIoGoogleCloudVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.beam.beam.sdks.java.io.google.cloud.platform</b> with value <b>2.60.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPlatform() { return getVersion("org.apache.beam.beam.sdks.java.io.google.cloud.platform"); }

    }

    public static class OrgApacheBeamBeamSdksJavaMyextensionsVersionAccessors extends VersionFactory  {

        public OrgApacheBeamBeamSdksJavaMyextensionsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.beam.beam.sdks.java.myextensions.python</b> with value <b>2.60.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPython() { return getVersion("org.apache.beam.beam.sdks.java.myextensions.python"); }

    }

    public static class OrgApacheKafkaVersionAccessors extends VersionFactory  {

        private final OrgApacheKafkaKafkaVersionAccessors vaccForOrgApacheKafkaKafkaVersionAccessors = new OrgApacheKafkaKafkaVersionAccessors(providers, config);
        public OrgApacheKafkaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.kafka.kafka</b>
         */
        public OrgApacheKafkaKafkaVersionAccessors getKafka() {
            return vaccForOrgApacheKafkaKafkaVersionAccessors;
        }

    }

    public static class OrgApacheKafkaKafkaVersionAccessors extends VersionFactory  {

        public OrgApacheKafkaKafkaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.kafka.kafka.clients</b> with value <b>2.4.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getClients() { return getVersion("org.apache.kafka.kafka.clients"); }

    }

    public static class OrgHamcrestVersionAccessors extends VersionFactory  {

        private final OrgHamcrestHamcrestVersionAccessors vaccForOrgHamcrestHamcrestVersionAccessors = new OrgHamcrestHamcrestVersionAccessors(providers, config);
        public OrgHamcrestVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.hamcrest.hamcrest</b>
         */
        public OrgHamcrestHamcrestVersionAccessors getHamcrest() {
            return vaccForOrgHamcrestHamcrestVersionAccessors;
        }

    }

    public static class OrgHamcrestHamcrestVersionAccessors extends VersionFactory  {

        public OrgHamcrestHamcrestVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.hamcrest.hamcrest.core</b> with value <b>2.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("org.hamcrest.hamcrest.core"); }

        /**
         * Version alias <b>org.hamcrest.hamcrest.library</b> with value <b>2.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLibrary() { return getVersion("org.hamcrest.hamcrest.library"); }

    }

    public static class OrgMockitoVersionAccessors extends VersionFactory  {

        private final OrgMockitoMockitoVersionAccessors vaccForOrgMockitoMockitoVersionAccessors = new OrgMockitoMockitoVersionAccessors(providers, config);
        public OrgMockitoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.mockito.mockito</b>
         */
        public OrgMockitoMockitoVersionAccessors getMockito() {
            return vaccForOrgMockitoMockitoVersionAccessors;
        }

    }

    public static class OrgMockitoMockitoVersionAccessors extends VersionFactory  {

        public OrgMockitoMockitoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.mockito.mockito.core</b> with value <b>3.7.7</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("org.mockito.mockito.core"); }

    }

    public static class OrgSlf4jVersionAccessors extends VersionFactory  {

        private final OrgSlf4jSlf4jVersionAccessors vaccForOrgSlf4jSlf4jVersionAccessors = new OrgSlf4jSlf4jVersionAccessors(providers, config);
        public OrgSlf4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.slf4j.slf4j</b>
         */
        public OrgSlf4jSlf4jVersionAccessors getSlf4j() {
            return vaccForOrgSlf4jSlf4jVersionAccessors;
        }

    }

    public static class OrgSlf4jSlf4jVersionAccessors extends VersionFactory  {

        public OrgSlf4jSlf4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.slf4j.slf4j.api</b> with value <b>1.7.30</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("org.slf4j.slf4j.api"); }

        /**
         * Version alias <b>org.slf4j.slf4j.jdk14</b> with value <b>1.7.30</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJdk14() { return getVersion("org.slf4j.slf4j.jdk14"); }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
