import gql from "graphql-tag";

export const newImg = gql`
  mutation newImg($file: Upload!) {
    newImg(file: $file) {
      url
      name
      created
      id
    }
  }
`;

export const deleteImg = gql`
  mutation deleteImg($id: ID!) {
    deleteImg(id: $id)
  }
`;

export const newVideo = gql`
  mutation newVideo($file: Upload!, $title: String!, $description: String!) {
    newVideo(file: $file, title: $title, description: $description) {
      url
      name
      title
      description
      id
    }
  }
`;
export const updateVideo = gql`
  mutation updateVideo($id: ID!, $title: String!, $description: String!) {
    updateVideo(id: $id, title: $title, description: $description) {
      title
      description
    }
  }
`;
export const deleteVideo = gql`
  mutation deleteVideo($id: ID!) {
    deleteVideo(id: $id)
  }
`;

export const newText = gql`
  mutation newText($text: String!) {
    newText(text: $text) {
      text
      id
    }
  }
`;

export const deleteText = gql`
  mutation deleteText($id: ID!) {
    deleteText(id: $id)
  }
`;

export const newContent = gql`
  mutation newContent(
    $typeContent: String!
    $idType: ID!
    $description: String!
    $lessonId: ID!
  ) {
    newContent(
      typeContent: $typeContent
      idType: $idType
      description: $description
      lessonId: $lessonId
    ) {
      id
      description
      typeContent
      idType
    }
  }
`;

export const deleteContent = gql`
  mutation deleteContent($id: ID!) {
    deleteContent(id: $id)
  }
`;
