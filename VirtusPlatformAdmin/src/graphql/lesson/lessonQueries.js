import gql from "graphql-tag";

export const contOfModId = gql`
  query lessonById($id: ID!) {
    lessonById(id: $id) {
      title
      module {
        title
        course {
          name
        }
      }
      contents {
        id
        description
        typeContent
        idType
      }
    }
  }
`;
