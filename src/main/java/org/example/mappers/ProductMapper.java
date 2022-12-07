package org.example.mappers;

import org.apache.commons.lang3.math.NumberUtils;
import org.example.domain.*;

import java.util.Map;

import static org.example.domain.Classification.CLASSIFICATIONS_GPC;
import static org.example.domain.ConsumerUnit.*;
import static org.example.domain.DistributionUnit.*;
import static org.example.domain.Group.*;
import static org.example.domain.Product.*;
import static org.example.domain.Sustainability.*;
import static org.example.mappers.BaseModelMapper.mapToOtherData;

public class ProductMapper {

    private static final String TRANSPORTATION_UNIT_WIDTH = "transportation_unit:width";
    private static final String TRANSPORTATION_UNIT_LENGTH = "transportation_unit:length";
    private static final String TRANSPORTATION_UNIT_HEIGHT = "transportation_unit:height";
    private static final String TRANSPORTATION_UNIT_VOLUME = "transportation_unit:volume";
    private static final String DESCRIPTIONS_MAIN = "descriptions:MAIN";
    private static final String DOCUMENTS_OTHER = "documents:Other";
    private static final String DOCUMENTS_EPD = "documents:EPD";
    private static final String MODELS_SKETCH_UP = "models:SketchUp";
    private static final String MODELS_REVIT = "models:Revit";
    private static final String MODELS_OTHER = "models:Other";
    private static final String MODELS_IFC = "models:IFC";
    private static final String MODELS_DWG = "models:DWG";
    private static final String SPECIFICATIONS_DESIGNER = "specifications:DESIGNER";
    private static final String SPECIFICATIONS_CONSUMPTION = "specifications:CONSUMPTION";
    private static final String SPECIFICATIONS_CAPACITY = "specifications:CAPACITY";
    private static final String PHYSICAL_MEASUREMENTS_WIDTH = "physical_measurements:WIDTH";
    private static final String PHYSICAL_MEASUREMENTS_HEIGHT = "physical_measurements:HEIGHT";
    private static final String PHYSICAL_MEASUREMENTS_DEPTH = "physical_measurements:DEPTH";
    private static final String ID_NUMBERS_NOBB = "id_numbers:NOBB";
    private static final String ID_NUMBERS_FINFO = "id_numbers:FINFO";

    public static Product mapToProduct(Map<String, String> data) {
        if (data == null) {
            return null;
        } else {
            Product.ProductBuilder<?, ?> product = Product.builder();
            product.specification(mapToSpecification(data));
            product.physicalMeasurement(mapToPhysicalMeasurement(data));
            product.model(mapToModel(data));
            product.idNumber(mapToIdNumber(data));
            product.document(mapToDocument(data));
            product.transportationUnit(mapToTransportationUnit(data));
            product.distributionUnit(mapToDistributionUnit(data));
            product.description(mapToDescription(data));
            product.consumerUnit(mapToConsumerUnit(data));
            product.classification(mapToClassification(data));
            product.sustainability(mapToSustainability(data));
            product.group(mapToGroup(data));
            if (data.containsKey(MASTER_PRODUCT)) {
                product.masterProduct(data.get(MASTER_PRODUCT));
                data.remove(MASTER_PRODUCT);
            }

            if (data.containsKey(MARKETS)) {
                product.markets(data.get(MARKETS));
                data.remove(MARKETS);
            }

            if (data.containsKey(NAME)) {
                product.name(data.get(NAME));
                data.remove(NAME);
            }

            if (data.containsKey(EXTERNAL_ID)) {
                product.externalId(data.get(EXTERNAL_ID));
                data.remove(EXTERNAL_ID);
            }

            if (data.containsKey(CERTIFICATION)) {
                product.certification(data.get(CERTIFICATION));
                data.remove(CERTIFICATION);
            }

            if (data.containsKey(BRAND)) {
                product.brand(data.get(BRAND));
                data.remove(BRAND);
            }

            product.otherData(mapToOtherData(data));

            return product.build();
        }
    }

    private static Group mapToGroup(Map<String, String> data) {
        if (data == null) {
            return null;
        } else {
            Group.GroupBuilder group = Group.builder();
            if (data.containsKey(GROUP_RANGE)) {
                group.range(data.get(GROUP_RANGE));
                data.remove(GROUP_RANGE);
            }

            if (data.containsKey(GROUP_FAMILY)) {
                group.family(data.get(GROUP_FAMILY));
                data.remove(GROUP_FAMILY);
            }

            if (data.containsKey(GROUP_COLLECTION)) {
                group.collection(data.get(GROUP_COLLECTION));
                data.remove(GROUP_COLLECTION);
            }

            if (data.containsKey(GROUP_CATEGORY)) {
                group.category(data.get(GROUP_CATEGORY));
                data.remove(GROUP_CATEGORY);
            }

            return group.build();
        }
    }

    private static Sustainability mapToSustainability(Map<String, String> data) {
        if (data == null) {
            return null;
        } else {
            Sustainability.SustainabilityBuilder sustainability = Sustainability.builder();
            if (data.containsKey(SUSTAINABILITY_VALIDITY_PERIOD)) {
                sustainability.validityPeriod(data.get(SUSTAINABILITY_VALIDITY_PERIOD));
                data.remove(SUSTAINABILITY_VALIDITY_PERIOD);
            }

            if (data.containsKey(SUSTAINABILITY_NORMALIZED_GWD)) {
                sustainability.normalizedGwd(NumberUtils.toDouble(data.get(SUSTAINABILITY_NORMALIZED_GWD)));
                data.remove(SUSTAINABILITY_NORMALIZED_GWD);
            }

            if (data.containsKey(SUSTAINABILITY_GWD)) {
                sustainability.gwd(NumberUtils.toDouble(data.get(SUSTAINABILITY_GWD)));
                data.remove(SUSTAINABILITY_GWD);
            }

            return sustainability.build();
        }
    }

    private static Classification mapToClassification(Map<String, String> data) {
        if (data == null) {
            return null;
        } else {
            Classification.ClassificationBuilder classification = Classification.builder();
            if (data.containsKey(CLASSIFICATIONS_GPC)) {
                classification.gpc(NumberUtils.toLong(data.get(CLASSIFICATIONS_GPC)));
                data.remove(CLASSIFICATIONS_GPC);
            }

            return classification.build();
        }
    }

    private static ConsumerUnit mapToConsumerUnit(Map<String, String> data) {
        if (data == null) {
            return null;
        } else {
            ConsumerUnit.ConsumerUnitBuilder<?, ?> consumerUnit = ConsumerUnit.builder();
            if (data.containsKey(CONSUMER_UNIT_WIDTH)) {
                consumerUnit.width(NumberUtils.toDouble(data.get(CONSUMER_UNIT_WIDTH)));
                data.remove(CONSUMER_UNIT_WIDTH);
            }

            if (data.containsKey(CONSUMER_UNIT_LENGTH)) {
                consumerUnit.length(NumberUtils.toDouble(data.get(CONSUMER_UNIT_LENGTH)));
                data.remove(CONSUMER_UNIT_LENGTH);
            }

            if (data.containsKey(CONSUMER_UNIT_HEIGHT)) {
                consumerUnit.height(NumberUtils.toDouble(data.get(CONSUMER_UNIT_HEIGHT)));
                data.remove(CONSUMER_UNIT_HEIGHT);
            }

            return consumerUnit.build();
        }
    }

    private static DistributionUnit mapToDistributionUnit(Map<String, String> data) {
        if (data == null) {
            return null;
        } else {
            DistributionUnit.DistributionUnitBuilder<?, ?> distributionUnit = DistributionUnit.builder();
            if (data.containsKey(DISTRIBUTION_UNIT_WIDTH)) {
                distributionUnit.width(NumberUtils.toDouble(data.get(DISTRIBUTION_UNIT_WIDTH)));
                data.remove(DISTRIBUTION_UNIT_WIDTH);
            }

            if (data.containsKey(DISTRIBUTION_UNIT_LENGTH)) {
                distributionUnit.length(NumberUtils.toDouble(data.get(DISTRIBUTION_UNIT_LENGTH)));
                data.remove(DISTRIBUTION_UNIT_LENGTH);
            }

            if (data.containsKey(DISTRIBUTION_UNIT_HEIGHT)) {
                distributionUnit.height(NumberUtils.toDouble(data.get(DISTRIBUTION_UNIT_HEIGHT)));
                data.remove(DISTRIBUTION_UNIT_HEIGHT);
            }

            if (data.containsKey(DISTRIBUTION_UNIT_VOLUME)) {
                distributionUnit.volume(NumberUtils.toDouble(data.get(DISTRIBUTION_UNIT_VOLUME)));
                data.remove(DISTRIBUTION_UNIT_VOLUME);
            }

            return distributionUnit.build();
        }
    }

    private static TransportationUnit mapToTransportationUnit(Map<String, String> data) {
        if (data == null) {
            return null;
        } else {
            TransportationUnit.TransportationUnitBuilder<?, ?> transportationUnit = TransportationUnit.builder();
            if (data.containsKey(TRANSPORTATION_UNIT_WIDTH)) {
                transportationUnit.width(NumberUtils.toDouble(data.get(TRANSPORTATION_UNIT_WIDTH)));
                data.remove(TRANSPORTATION_UNIT_WIDTH);
            }

            if (data.containsKey(TRANSPORTATION_UNIT_LENGTH)) {
                transportationUnit.length(NumberUtils.toDouble(data.get(TRANSPORTATION_UNIT_LENGTH)));
                data.remove(TRANSPORTATION_UNIT_LENGTH);
            }

            if (data.containsKey(TRANSPORTATION_UNIT_HEIGHT)) {
                transportationUnit.height(NumberUtils.toDouble(data.get(TRANSPORTATION_UNIT_HEIGHT)));
                data.remove(TRANSPORTATION_UNIT_HEIGHT);
            }

            if (data.containsKey(TRANSPORTATION_UNIT_VOLUME)) {
                transportationUnit.volume(NumberUtils.toDouble(data.get(TRANSPORTATION_UNIT_VOLUME)));
                data.remove(TRANSPORTATION_UNIT_VOLUME);
            }

            return transportationUnit.build();
        }
    }

    private static Description mapToDescription(Map<String, String> data) {
        if (data == null) {
            return null;
        } else {
            Description.DescriptionBuilder description = Description.builder();
            if (data.containsKey(DESCRIPTIONS_MAIN)) {
                description.main(data.get(DESCRIPTIONS_MAIN));
                data.remove(DESCRIPTIONS_MAIN);
            }

            return description.build();
        }
    }

    private static Document mapToDocument(Map<String, String> data) {
        if (data == null) {
            return null;
        } else {
            Document.DocumentBuilder document = Document.builder();
            if (data.containsKey(DOCUMENTS_OTHER)) {
                document.other(data.get(DOCUMENTS_OTHER));
                data.remove(DOCUMENTS_OTHER);
            }

            if (data.containsKey(DOCUMENTS_EPD)) {
                document.epd(data.get(DOCUMENTS_EPD));
                data.remove(DOCUMENTS_EPD);
            }

            return document.build();
        }
    }

    private static Model mapToModel(Map<String, String> data) {
        if (data == null) {
            return null;
        } else {
            Model.ModelBuilder model = Model.builder();
            if (data.containsKey(MODELS_SKETCH_UP)) {
                model.sketchUp(data.get(MODELS_SKETCH_UP));
                data.remove(MODELS_SKETCH_UP);
            }

            if (data.containsKey(MODELS_REVIT)) {
                model.revit(data.get(MODELS_REVIT));
                data.remove(MODELS_REVIT);
            }

            if (data.containsKey(MODELS_OTHER)) {
                model.other(data.get(MODELS_OTHER));
                data.remove(MODELS_OTHER);
            }

            if (data.containsKey(MODELS_IFC)) {
                model.ifc(data.get(MODELS_IFC));
                data.remove(MODELS_IFC);
            }

            if (data.containsKey(MODELS_DWG)) {
                model.dwg(data.get(MODELS_DWG));
                data.remove(MODELS_DWG);
            }

            return model.build();
        }
    }

    private static Specification mapToSpecification(Map<String, String> data) {
        if (data == null) {
            return null;
        } else {
            Specification.SpecificationBuilder specification = Specification.builder();
            if (data.containsKey(SPECIFICATIONS_DESIGNER)) {
                specification.designer(data.get(SPECIFICATIONS_DESIGNER));
                data.remove(SPECIFICATIONS_DESIGNER);
            }

            if (data.containsKey(SPECIFICATIONS_CONSUMPTION)) {
                specification.consumption(data.get(SPECIFICATIONS_CONSUMPTION));
                data.remove(SPECIFICATIONS_CONSUMPTION);
            }

            if (data.containsKey(SPECIFICATIONS_CAPACITY)) {
                specification.capacity(data.get(SPECIFICATIONS_CAPACITY));
                data.remove(SPECIFICATIONS_CAPACITY);
            }

            return specification.build();
        }
    }

    private static PhysicalMeasurement mapToPhysicalMeasurement(Map<String, String> data) {
        if (data == null) {
            return null;
        } else {
            PhysicalMeasurement.PhysicalMeasurementBuilder physicalMeasurement = PhysicalMeasurement.builder();
            if (data.containsKey(PHYSICAL_MEASUREMENTS_WIDTH)) {
                physicalMeasurement.width(NumberUtils.toInt(data.get(PHYSICAL_MEASUREMENTS_WIDTH)));
                data.remove(PHYSICAL_MEASUREMENTS_WIDTH);
            }

            if (data.containsKey(PHYSICAL_MEASUREMENTS_HEIGHT)) {
                physicalMeasurement.height(NumberUtils.toInt(data.get(PHYSICAL_MEASUREMENTS_HEIGHT)));
                data.remove(PHYSICAL_MEASUREMENTS_HEIGHT);
            }

            if (data.containsKey(PHYSICAL_MEASUREMENTS_DEPTH)) {
                physicalMeasurement.depth(NumberUtils.toInt(data.get(PHYSICAL_MEASUREMENTS_DEPTH)));
                data.remove(PHYSICAL_MEASUREMENTS_DEPTH);
            }

            return physicalMeasurement.build();
        }
    }

    private static IdNumber mapToIdNumber(Map<String, String> data) {
        if (data == null) {
            return null;
        } else {
            IdNumber.IdNumberBuilder idNumber = IdNumber.builder();
            if (data.containsKey(ID_NUMBERS_NOBB)) {
                idNumber.nobb(NumberUtils.toLong(data.get(ID_NUMBERS_NOBB)));
                data.remove(ID_NUMBERS_NOBB);
            }

            if (data.containsKey(ID_NUMBERS_FINFO)) {
                idNumber.finfo(NumberUtils.toLong(data.get(ID_NUMBERS_FINFO)));
                data.remove(ID_NUMBERS_FINFO);
            }

            return idNumber.build();
        }
    }
}
